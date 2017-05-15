package monumemory.controllers;

import java.util.List;
import javax.validation.Valid;
import monumemory.controllers.exceptions.NotFoundException;
import monumemory.dto.PhotoSetDto;
import monumemory.models.*;
import monumemory.services.MonumentsService;
import monumemory.services.PhotoSetsService;
import monumemory.services.PhotosService;
import monumemory.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("photo_sets/")
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class PhotoSetsController extends AbstractCrudController {

    @Autowired
    private MonumentsService monumentsService;

    @Autowired
    private PhotoSetsService photoSetsService;

    @Autowired
    private PhotosService photosService;

    @Autowired
    private FileSystemStorageService storageService;

    @GetMapping("{monumentId}/list/")
    public String list(Model model,
                       @PathVariable Integer monumentId) {
        final MonumentModelInterface monumentModel = getMonumentModel(monumentId);
        final List<PhotoSetModelInterface> photoSetModels
                = this.photoSetsService.findByMonument(monumentModel);

        model.addAttribute("monument", monumentModel);
        model.addAttribute("photoSets", photoSetModels);
        return "photo_sets/list";
    }

    @GetMapping("{photoSetId}/")
    public String view(Model model,
                       @PathVariable Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = getPhotoSetModel(photoSetId);
        final List<PhotoModelInterface> photos = this.photosService.findByPhotoSet(photoSetModel);
        final MonumentModelInterface monumentModel = this.monumentsService.find(photoSetModel.getMonument().getId());

        model.addAttribute("monument", monumentModel);
        model.addAttribute("photoSet", photoSetModel);
        model.addAttribute("photos", photos);
        return "photo_sets/view";
    }

    @GetMapping("{monumentId}/create/")
    public String create(Model model,
                         @PathVariable Integer monumentId) {
        final MonumentModelInterface monumentModel = getMonumentModel(monumentId);
        final PhotoSetDto photoSetDto = new PhotoSetDto();

        setCreateBehaviour(model);
        model.addAttribute("monument", monumentModel);
        model.addAttribute("photoSetDto", photoSetDto);
        return "photo_sets/form";
    }

    @PostMapping("{monumentId}/create/")
    public String insert(Model model,
                         @PathVariable Integer monumentId,
                         @Valid PhotoSetDto photoSetDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final MonumentModelInterface monumentModel = getMonumentModel(monumentId);
            setCreateBehaviour(model);
            model.addAttribute("monument", monumentModel);
            model.addAttribute("photoSetDto", photoSetDto);
            return "photo_sets/form";
        }
        final PhotoSetModelInterface photoSetModel = getModelFromDto(photoSetDto, null);
        this.photoSetsService.insert(photoSetModel);
        return "redirect:/photo_sets/{monumentId}/list/";
    }

    @GetMapping("update/{photoSetId}/")
    public String update(Model model,
                         @PathVariable Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = getPhotoSetModel(photoSetId);
        final MonumentModelInterface monumentModel = this.monumentsService.find(photoSetModel.getMonument().getId());
        final PhotoSetDto photoSetDto = new PhotoSetDto();
        photoSetDto.map(photoSetModel);

        setUpdateBehaviour(model);
        model.addAttribute("monument", monumentModel);
        model.addAttribute("photoSetDto", photoSetDto);
        return "photo_sets/form";
    }

    @PostMapping("update/{photoSetId}/")
    public String save(Model model,
                         @PathVariable Integer photoSetId,
                         @Valid PhotoSetDto photoSetDto,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            final MonumentModelInterface monumentModel = getMonumentModel(photoSetDto.getMonumentId());
            setUpdateBehaviour(model);
            model.addAttribute("monument", monumentModel);
            model.addAttribute("photoSetDto", photoSetDto);
            return "photo_sets/form";
        }
        final PhotoSetModelInterface photoSetModel = getModelFromDto(photoSetDto, null);
        this.photoSetsService.update(photoSetModel);
        return "redirect:/photo_sets/" + photoSetDto.getMonumentId() + "/list/";
    }

    @PostMapping("delete/{photoSetId}/")
    public String delete(Model model, @PathVariable Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = getPhotoSetModel(photoSetId);
        deleteWithRelations(photoSetModel);
        return "redirect:/photo_sets/" + photoSetModel.getMonument().getId() + "/list/";
    }

    private MonumentModelInterface getMonumentModel(Integer monumentId) {
        final MonumentModelInterface monumentModel = this.monumentsService.find(monumentId);
        if (monumentModel == null) {
            throw new NotFoundException();
        }
        return monumentModel;
    }

    private PhotoSetModelInterface getPhotoSetModel(Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = this.photoSetsService.find(photoSetId);
        if (photoSetModel == null) {
            throw new NotFoundException();
        }
        return photoSetModel;
    }

    private PhotoSetModelInterface getModelFromDto(PhotoSetDto photoSetDto, Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = new PhotoSetModel();
        photoSetModel.setId(photoSetId);
        photoSetDto.mapInto(photoSetModel);
        return photoSetModel;
    }

    private void deleteWithRelations(PhotoSetModelInterface photoSetModel) {
        final List<PhotoModelInterface> photoModels = this.photosService.findByPhotoSet(photoSetModel);
        for (PhotoModelInterface photoModel: photoModels) {
            this.storageService.delete(photoModel.getPath());
            this.photosService.delete(photoModel);
        }
        this.photoSetsService.delete(photoSetModel);
    }
}
