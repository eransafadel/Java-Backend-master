package main.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import main.beans.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SpringSessionController
 */
@Controller
public class SpringSessionController {

    @Resource(name = "SessionUser")
    private SessionUser messages;

    /**
     *
     * @param model - just a model.
     * @return  session.
     */
    @GetMapping("/session")
    public String process(Model model)
    {
        model.addAttribute("sessionMessages", messages.getFlag());
        return "session";// view
    }

    /**
     *
     * @param msg string msg
     * @return redirect:/session
     */
    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("msg") String msg )
    {

        return "redirect:/session";
    }

    /**
     *
     * @param request a request.
     * @return redirect:/session
     */
    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/session";
    }
}