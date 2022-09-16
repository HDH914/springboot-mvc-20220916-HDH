package com.boot.mvc20220916hdh.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController  //RESP API 방식
public class ResponseBodyController {

//    Logger LOGGER = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @GetMapping("/api/text")    //GetMapping: Post요청 방식, Read(조회)
    public String textGetReq(@RequestParam("value") String value, @RequestParam int num){  //변수명이 일치해야함
        return "파라미터 값:" + value + ", " + num;
    }

    @ResponseBody
    @PostMapping("/api/text")    //PostMapping: Post요청 방식, Create(생성)
    public String textPostReq(@RequestParam String name, int age){
        log.info("name: {}", name);
        log.info("age: {}", age);
        return "name: " + name + ", age: " + age;
    }

    @ResponseBody
    @PutMapping("/api/text")    //PutMapping: Put요청 방식, Update(수정)
    public String textPutReq(){
        log.info("put Request");
        return "put요청에 대한 응답";
    }

    @ResponseBody
    @DeleteMapping("/api/text")    //DeleteMapping: Delete요청 방식, Delete(삭제)
    public String textDeleteReq(){
        log.info("delete Requset");
        return "delete 요청에 대한 응답";
    }
}
