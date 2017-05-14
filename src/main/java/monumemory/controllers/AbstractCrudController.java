package monumemory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public abstract class AbstractCrudController {

    protected static void setCreateBehaviour(Model model) {
        model.addAttribute("isNewModel", true);
    }

    protected static void setUpdateBehaviour(Model model) {
        model.addAttribute("isNewModel", false);
    }
}
