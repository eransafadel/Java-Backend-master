package main.controllers;


import main.Model.SuccessLogin;
import main.beans.Login;
import main.beans.SessionUser;

import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.validation.Valid;

/**
 * MainController - responsible start to  navigate to other controllers.
 */
@Controller
public class MainController
{
    @Value("${const.name}")
    private String name;

    /**
     * @return return String name.
     */
    public String getName() {
        return name;
    }

    @Value("${const.password}")
    private String pass;

    /**
     *
     * @return return String pass.
     */
    public String getPass() {
        return pass;
    }


    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /* we need it so  inject the User repo bean */

    @Autowired
    private UserRepository repository;

    /**
     * @return return UserRepository
     */
    private UserRepository getRepo() {
        return repository;
    }

    /**
     * Main function.
     * @return ResultsGithub if user logged in ,else  redirect to login
     */
    @GetMapping("/")
    public String main() {

        if (insSession.getFlag()&& insSession != null)
            return "redirect:/ResultsGithub"; //get
        return "redirect:/login";
    }


    /**
     *
     * @param login Login : that contains the name and password for user
     * @param model  Model: Java-5-specific interface that defines a holder for model attributes.
     * @return obj - that indicate if user logged in
     */
    @PostMapping("/actionlogin")
    public @ResponseBody
    SuccessLogin getJson(@Valid @RequestBody Login login, Model model) {
        String name = login.getName();
        String pass = login.getPassword();
        SuccessLogin obj = new SuccessLogin();
        if (name.equals(getName()) && pass.equals(getPass())) {
            insSession.setFlag(true);
            obj.setSuccess(true);
        } else {
            model.addAttribute("msgError", " Wrong in name or password, please try again!");
            model.addAttribute("obj", false);
            obj.setSuccess(false);
        }
        return obj;
    }

}

