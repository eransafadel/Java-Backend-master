package main.controllers;

import main.beans.SessionUser;
import main.repo.ReadUserFromGithub;
import main.repo.User;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * ResultSearchGithubController - responsible for searches on github.
 */
@Controller
public class ResultSearchGithubController
{
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    @Autowired
    private UserRepository repository;

    /**
     * getRepo- get function.
     * @return return UserRepository.
     */
    private UserRepository getRepo() {
        return repository;
    }


    /**
     * getResults- func get.
        * @param model - a model
     * @return searchGithub page if user logged in. else- redirect to login.
     */
    @GetMapping("/ResultsGithub")
    public String getResults(Model model) {
        if (insSession.getFlag()&& insSession != null) {
            model.addAttribute("html_url", "");
            model.addAttribute("login", "");
            model.addAttribute("followers", "");
            model.addAttribute("msg", "");
            return "searchGithub";
        }
        return "redirect:/login";
    }

    /**
     *
     * @param userName - String that holds the user name.
     * @param user - User - contains username,id , count and url of user.
     * @param model a model.
     * @return  searchGithub page if user logged in or redirect to login if user not logged in.
     */
    @PostMapping("/ResultsGithub")
    public String result(@RequestParam(value = "userName", required = false, defaultValue = " ") String userName, @Valid User user, Model model) {
        if (insSession.getFlag())
        {
            ReadUserFromGithub readUserFromGithub = new ReadUserFromGithub(user, userName, model, getRepo());
            try {
                readUserFromGithub.read();
            } catch (MalformedURLException e)
            {
                return "ErrorOnGitHub";
            } catch (IOException e) {
                model.addAttribute("msg", "This user not exist!");
            }
            return "searchGithub";
        }
        return "redirect:/login";
    }



}
