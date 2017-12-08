package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String,String> model){
        model.put("variable", "My Thymeleaf variable");
        model.put("one", "1");
        model.put("two", "2");
        model.put("six", "6");
        model.put("four", "4");
        model.put("equals", "=");
        model.put("minus", "-");
        model.put("add", "+");
        model.put("multi", "*");

        return "index";
    }
}
