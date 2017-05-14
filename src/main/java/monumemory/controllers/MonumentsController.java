package monumemory.controllers;

import java.util.List;
import javax.validation.Valid;
import monumemory.controllers.exceptions.NotFoundException;
import monumemory.dto.MonumentDto;
import monumemory.models.MonumentModel;
import monumemory.models.MonumentModelInterface;
import monumemory.models.PhotoModelInterface;
import monumemory.models.PhotoSetModelInterface;
import monumemory.services.MonumentsService;
import monumemory.services.PhotoSetsService;
import monumemory.services.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("monuments/")
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class MonumentsController extends AbstractCrudController {

    @Autowired
    private MonumentsService monumentsService;

    @Autowired
    private PhotoSetsService photoSetsService;

    @Autowired
    private PhotosService photosService;

    @GetMapping("")
    public String list(Model model) {
        final List<MonumentModelInterface> monumentModels = this.monumentsService.findAll();
        model.addAttribute("monuments", monumentModels);
        return "monuments/list";
    }

    @GetMapping("{monumentId}/")
    public String view(Model model,
                       @PathVariable Integer monumentId) {
        final MonumentModelInterface monumentModel = this.monumentsService.find(monumentId);
        if (monumentModel == null) {
            throw new NotFoundException();
        }
        model.addAttribute("monument", monumentModel);
        return "monuments/view";
    }

    @GetMapping("create/")
    public String create(Model model) {
        final MonumentDto monumentDto = new MonumentDto();
        model.addAttribute("monumentDto", monumentDto);

        setCreateBehaviour(model);
        return "monuments/form";
    }

    @PostMapping("create/")
    public String insert(Model model,
                         @Valid MonumentDto monumentDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("monumentDto", monumentDto);
            model.addAttribute("errors", bindingResult);

            setCreateBehaviour(model);
            return "monuments/form";
        }
        final MonumentModelInterface monumentModel = getModelFromDto(monumentDto, null);
        //System.out.println(monumentModel);
        this.monumentsService.insert(monumentModel);
        return "redirect:/monuments/";
    }

    @GetMapping("update/{monumentId}/")
    public String update(Model model,
                         @PathVariable Integer monumentId) {
        final MonumentModelInterface monumentModel = this.monumentsService.find(monumentId);
        if (monumentModel == null) {
            throw new NotFoundException();
        }
        final MonumentDto monumentDto = new MonumentDto();
        monumentDto.map(monumentModel);

        setUpdateBehaviour(model);
        model.addAttribute("monumentDto", monumentDto);
        return "monuments/form";
    }

    @PostMapping("update/{monumentId}/")
    public String save(Model model,
                       @PathVariable Integer monumentId,
                       @Valid MonumentDto monumentDto,
                       BindingResult bindingResult) {
        System.out.println(monumentDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("monumentDto", monumentDto);
            model.addAttribute("errors", bindingResult);

            setUpdateBehaviour(model);
            return "monuments/form";
        }
        final MonumentModelInterface monumentModel = getModelFromDto(monumentDto, monumentId);
        //System.out.println(monumentModel);
        this.monumentsService.update(monumentModel);
        return "redirect:/monuments/{monumentId}/";
    }

    @PostMapping("delete/{monumentId}/")
    public String delete(Model model, @PathVariable Integer monumentId) {
        final MonumentModelInterface monumentModel = this.monumentsService.find(monumentId);
        if (monumentModel == null) {
            throw new NotFoundException();
        }
        //System.out.println(monumentModel);
        deleteWithRelations(monumentModel);
        return "redirect:/monuments/";
    }

    private MonumentModelInterface getModelFromDto(MonumentDto monumentDto, Integer monumentId) {
        final MonumentModelInterface monumentModel = new MonumentModel();
        monumentModel.setId(monumentId);
        monumentDto.mapInto(monumentModel);
        return monumentModel;
    }

    private void deleteWithRelations(MonumentModelInterface monumentModel) {
        final List<PhotoSetModelInterface> photoSetModels = this.photoSetsService.findByMonument(monumentModel);
        for (PhotoSetModelInterface photoSetModel: photoSetModels) {
            final List<PhotoModelInterface> photoModels = this.photosService.findByPhotoSet(photoSetModel);
            for (PhotoModelInterface photoModel: photoModels) {
                this.photosService.delete(photoModel);
            }
            this.photoSetsService.delete(photoSetModel);
        }
        this.monumentsService.delete(monumentModel);
    }

    @ModelAttribute("monumentListUrl")
    public String getMonumentsListUrl() {
        return "/monuments/";
    }

    @ModelAttribute("monumentCreateUrl")
    public String getMonumentCreateUrl() {
        return "/monuments/create/";
    }

    @ModelAttribute("monumentViewUrl")
    public String getMonumentViewUrl() {
        return "/monuments/%d/";
    }

    @ModelAttribute("monumentUpdateUrl")
    public String getMonumentUpdateUrl() {
        return "/monuments/update/%d/";
    }

    @ModelAttribute("monumentDeleteUrl")
    public String getMonumentDeleteUrl() {
        return "/monuments/delete/%d/";
    }
}
