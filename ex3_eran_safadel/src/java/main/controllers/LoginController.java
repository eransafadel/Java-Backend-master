package main.controllers;

import main.beans.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * LoginController - responsible for login to website
 */
@Controller
public class LoginController
{
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     *
     * @param model - Java-5-specific interface that defines a holder for model attributes.
     * @return ResultsGithub if user logged in, else : login page.
     */
    @RequestMapping("/login")
    public String loginGet(Model model) {
        if (insSession.getFlag())
            return "redirect:/ResultsGithub";

        model.addAttribute("msgError", " ");
        return "login";
    }
}
