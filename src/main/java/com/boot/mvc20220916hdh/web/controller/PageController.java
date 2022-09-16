package com.boot.mvc20220916hdh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller    //controller어노테이션
public class PageController {

    //서버 사이드 랜더링: 서버측에서 html을 랜더링해서 완성시킨후 보여준다.
    @GetMapping({"/", "/index"})    //HandlerMapping에 등록하는 것, 주소
    public String loadIndex(Model model){
        model.addAttribute("name", "DH");  //request.setAttribute랑 동일
        return "index";    //html파일명
    }
    @GetMapping("/helloboot")
    public String loadHelloBoot(Model model){
        model.addAttribute("nowDate", LocalDateTime.now());
        return "Hello";
    }

    @GetMapping("/myinfo")
    public String loaMmyInfo(Model model){
        model.addAttribute("name", "HDH");
        model.addAttribute("age", "28");
        model.addAttribute("phone", "010-1234-5678");
        model.addAttribute("address", "sdgsdgsd");
        return "myinfo";
    }
}
