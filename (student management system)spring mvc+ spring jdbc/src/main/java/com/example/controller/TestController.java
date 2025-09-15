package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test/hello")
    public String sayHello(Model model) {
        // Add a message attribute to send to the JSP page
        model.addAttribute("message", "Spring MVC + JDBC wiring is successful!");
        
        // return the logical view name -> resolves to /WEB-INF/views/hello.jsp
        return "hello";
    }
}
