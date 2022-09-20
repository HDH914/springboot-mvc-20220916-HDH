package com.boot.mvc20220916hdh.web.controller.api;

import com.boot.mvc20220916hdh.web.dto.ResponseDataDto;
import com.boot.mvc20220916hdh.web.dto.StudentResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ResponseTestController {

//  @ResponseBody    controller에서 필수, 응답이 객체형태면 json으로 자동 변경
    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "HDH");
        data.put("연락처", "010-1234-5678");

        return data;
    }

    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2(){
        return ResponseDataDto.builder()
                .value1("그냥 문자열")
                .value2(1000)
                .value3(true)
                .build();
    }

    @GetMapping("/api/v1/data3")
    public Object getData3(){   //타입을 Object라고 해도 ok
        return ResponseDataDto.builder()
                .value1("그냥 문자열2")
                .value2(2000)
                .value3(false)
                .build();
    }

    @GetMapping("/api/v1/students")
    public Object getData4(){
        Map<String, Object> responseMap = new HashMap<String, Object>();
        List<StudentResponseDto> studentList = new ArrayList<StudentResponseDto>();

        StudentResponseDto s1 = StudentResponseDto.builder()
                .studentCode(1)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산 진구")
                .studentPhone("010-9988-1916")
                .build();

        StudentResponseDto s2 = StudentResponseDto.builder()
                .studentCode(2)
                .studentName("김준이")
                .studentYear(4)
                .studentAddress("부산 북구")
                .studentPhone("010-9999-1234")
                .build();

        studentList.add(s1);
        studentList.add(s2);

        responseMap.put("students1", studentList);
//        responseMap.put("students2", studentList);

        return responseMap;
    }

//    @GetMapping("/api/v1/students")
//    public ResponseEntity<String> getStudentData(@RequestBody List<StudentDto> studentDto){
////        StudentDto studentDto = new StudentDto();
//
////        studentDto.setStudentCode(1);
////        studentDto.setStudentName("김준일");
////        studentDto.setStudentYear(2);
////        studentDto.setStudentAddress("부산 진구");
////        studentDto.setStudentPhone("010-9988-1916");
//
//
//
//        return ResponseEntity.ok(studentDto.toString());
//    }




}
