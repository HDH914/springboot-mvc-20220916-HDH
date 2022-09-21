package com.boot.mvc20220916hdh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AjaxTestController {

    @GetMapping("/ajax/{id}")
    public String loadAjax(@PathVariable int id){
        return "ajax/ajax" + id;
    }
}
