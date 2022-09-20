package com.boot.mvc20220916hdh.web.controller.api;

import com.boot.mvc20220916hdh.web.dto.CMRespDto;
import com.boot.mvc20220916hdh.web.dto.StudentResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData1(){
        return new ResponseEntity<String>("ResponseEntity 응답", HttpStatus.OK);  //200
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token", UUID.randomUUID().toString());
        return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);  //400
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token", UUID.randomUUID().toString());

        return new ResponseEntity<String>("test", headers, HttpStatus.INTERNAL_SERVER_ERROR);  //500
    }

    @GetMapping("/api/v1/entity/data4")
    public ResponseEntity<?> getData4(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token", UUID.randomUUID().toString());

        return new ResponseEntity<>(new CMRespDto<>(1, "전송 성공", "테스트 데이터"),
                headers,
                HttpStatus.NOT_FOUND);  //404
    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token", UUID.randomUUID().toString());

        return ResponseEntity   //스태틱 형태
                .ok()
                .headers((HttpHeaders) headers)
                .body(new CMRespDto<>(1, "message", "test"));
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData6(){
        ResponseTestController testController = new ResponseTestController();

        //헤더 부분
        HttpHeaders headers = new HttpHeaders();
        List<StudentResponseDto> dtoList = new ArrayList<StudentResponseDto>();

        dtoList.add(StudentResponseDto.builder().studentCode(20220001).build());
        dtoList.add(StudentResponseDto.builder().studentCode(20220002).build());

        StringBuilder studentCodeList = new StringBuilder();

       for(StudentResponseDto studentResponseDto : dtoList){
           studentCodeList.append(studentResponseDto.getStudentCode());
           studentCodeList.append(", ");
       }
       studentCodeList.delete(studentCodeList.length() - 2, studentCodeList.length());

       headers.add("student_code list", studentCodeList.toString());


        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(headers)
                .body(new CMRespDto<>(-1, "HTTP 메소드를 확인해 주세요.", testController.getData4()));

        /*
        return ResponseEntity<>(
                new CMRespDto<>(-1, "HTTP 메소드를 확인해 주세요.", testController.getData4()),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED
                );
        */


    }

}
