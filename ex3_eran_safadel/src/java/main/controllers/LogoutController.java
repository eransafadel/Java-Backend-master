package main.controllers;

import main.beans.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * LogoutController - responsible for logout from website
 *
 */
@Controller
public class LogoutController
{
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     *logout -  get func
     * @return  return login page.
     */
    @RequestMapping("/logout")
    public String logout() {
        insSession.setFlag(false);
        return "redirect:/login";
    }
}
