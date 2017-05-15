package monumemory.controllers;

import monumemory.storage.StorageProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public abstract class AbstractCrudController {

    protected static void setCreateBehaviour(Model model) {
        model.addAttribute("isNewModel", true);
    }

    protected static void setUpdateBehaviour(Model model) {
        model.addAttribute("isNewModel", false);
    }

    @ModelAttribute("monumentListUrl")
    public String getMonumentListUrl() {
        return "/monuments/list/";
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

    @ModelAttribute("photoSetListUrl")
    public String getPhotoSetListUrl() {
        return "/photo_sets/%d/list/";
    }

    @ModelAttribute("photoSetCreateUrl")
    public String getPhotoSetCreateUrl() {
        return "/photo_sets/%d/create/";
    }

    @ModelAttribute("photoSetViewUrl")
    public String getPhotoSetViewUrl() {
        return "/photo_sets/%d/";
    }

    @ModelAttribute("photoSetUpdateUrl")
    public String getPhotoSetUpdateUrl() {
        return "/photo_sets/update/%d/";
    }

    @ModelAttribute("photoSetDeleteUrl")
    public String getPhotoSetDeleteUrl() {
        return "/photo_sets/delete/%d/";
    }

    @ModelAttribute("photoCreateUrl")
    public String getPhotoCreateUrl() {
        return "/photos/%d/create/";
    }
}
