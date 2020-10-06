package main.controllers;

import main.beans.SessionUser;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * ResultHistoryGithubController -show the result history.
 */
@Controller
public class ResultHistoryGithubController {


    @Resource(name = "SessionUser")
    private SessionUser insSession;

    @Autowired
    private UserRepository repository;

    /**
     * getRepo - get func.
     * @return - return UserRepository.
     */
    private UserRepository getRepo() {
        return repository;
    }


    /**
     *
     * @param model - a model.
     * @return DisplayHistory if logged in . else - redirect to login.
     */
    @RequestMapping("/ResultsHistory")
    public String displayHistory(Model model) {
        if (insSession.getFlag() && insSession != null) {
            model.addAttribute("users", getRepo().findFirst10ByOrderByCountDesc());
            return "DisplayHistory";
        }
        return "redirect:/login";
    }

}