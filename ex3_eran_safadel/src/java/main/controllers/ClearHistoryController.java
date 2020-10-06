package main.controllers;

import main.beans.SessionUser;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * ClearHistoryController : clear the history of search
 */
@Controller
public class ClearHistoryController
{
    /**
     * The Resource annotation marks a resource that is needed
     *  * by the application.
     */
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     * Marks a constructor, field, setter method or config method as to be autowired by
     *  Spring's dependency injection facilities
     */
    @Autowired
    private UserRepository repository;

    /**
     * getRepo: get function
     * @return UserRepository
     */
    private UserRepository getRepo() {
        return repository;
    }

    /**
     *
     * @param model - ava-5-specific interface that defines a holder for model attributes.
     * @return DisplayHistory if user logged in else redirect to login controller.
     */
    @RequestMapping("/clearHistory")
    public String clearHistory(Model model)
    {
        if(insSession.getFlag() && insSession!=null) {
            getRepo().deleteAll();
            return "DisplayHistory";
        }
        return "redirect:/login";
    }
}
