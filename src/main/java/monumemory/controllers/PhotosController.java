package monumemory.controllers;

import java.util.UUID;
import javax.validation.Valid;
import monumemory.controllers.exceptions.NotFoundException;
import monumemory.dto.PhotoDto;
import monumemory.models.PhotoModel;
import monumemory.models.PhotoModelInterface;
import monumemory.models.PhotoSetModelInterface;
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
@RequestMapping("photos/")
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class PhotosController extends AbstractCrudController {

    @Autowired
    private PhotoSetsService photoSetsService;

    @Autowired
    private PhotosService photosService;

    @Autowired
    private FileSystemStorageService storageService;

    @GetMapping("/{photoSetId}/create/")
    public String create(Model model,
                         @PathVariable Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = getPhotoSetModel(photoSetId);
        final PhotoDto photoDto = new PhotoDto();

        model.addAttribute("photoSet", photoSetModel);
        model.addAttribute("photoDto", photoDto);
        return "photos/form";
    }

    @PostMapping("/{photoSetId}/create/")
    public String insert(Model model,
                         @PathVariable Integer photoSetId,
                         @Valid PhotoDto photoDto,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            final PhotoSetModelInterface photoSetModel = getPhotoSetModel(photoSetId);
            model.addAttribute("photoSet", photoSetModel);
            model.addAttribute("photoDto", photoDto);
            return "photos/form";
        }
        final PhotoModelInterface photoModel = new PhotoModel();
        photoDto.mapInto(photoModel);

        final String filename = generateFileName(photoModel.getId());
        photoModel.setPath(filename);
        this.photosService.insert(photoModel);

        storageService.store(photoDto.getFile(), filename);
        System.out.println(photoModel);
        return "redirect:/photo_sets/{photoSetId}/";
    }

    private PhotoSetModelInterface getPhotoSetModel(Integer photoSetId) {
        final PhotoSetModelInterface photoSetModel = this.photoSetsService.find(photoSetId);
        if (photoSetModel == null) {
            throw new NotFoundException();
        }
        return photoSetModel;
    }

    private String generateFileName(Integer photoId) {
        final UUID id = UUID.randomUUID();
        final String filename = id.toString().replaceAll("-", "") + ".jpeg";
        System.out.println(filename);
        return filename;
    }
}
