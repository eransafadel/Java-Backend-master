package main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    The @RestController annotation in Spring MVC is nothing but a combination of
    @Controller and @ResponseBody annotation

    it is equivalent to:
    @Controller
    @ResponseBody
    public class SessionDemoController { ....
*/

@RestController
public class SessionDemoController {

    @GetMapping("/get-session-count")
    public String testSessionListner(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(false);
        if(session == null){
            System.out.println("Unable to find session. Creating a new session");
            session = request.getSession(true);
        } else
            System.out.println("session exists with ID : " + session.getId());

        return "Session Test completed - look at program output";
    }
}