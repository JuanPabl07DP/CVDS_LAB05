package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/hellow")
    private String hellow(){
        return "Hellow Wold";
    }
    @RequestMapping("/user/id")
    private ModelAndView  getUser(@PathVariable Integer id, Model model){
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate.getForObject(uri, User.class);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}