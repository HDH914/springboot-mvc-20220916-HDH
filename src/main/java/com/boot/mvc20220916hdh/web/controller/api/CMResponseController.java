package com.boot.mvc20220916hdh.web.controller.api;

import com.boot.mvc20220916hdh.web.dto.CMRespDto;
import com.boot.mvc20220916hdh.web.dto.StudentResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
   CM(Commit Message)
   CMResponse
   커밋 메세지를 포함한 응답

*/

@RestController
public class CMResponseController {

    @GetMapping("/api/v1/cm/data1")
    public CMRespDto<?> getData1(){
        return new CMRespDto<String>(1, "데이터 응답 성공", "테스트 데이터");
    }

    @GetMapping("/api/v1/cm/data2")
    public CMRespDto<?> getData2(){
        return new CMRespDto<Boolean>(-1, "데이터 응답 실패", false);
    }

    @GetMapping("/api/v1/cm/data3")
    public CMRespDto<?> getData3(){
        List<StudentResponseDto> dtoList = new ArrayList<StudentResponseDto>();

        dtoList.add(StudentResponseDto.builder().studentCode(1).build());
        dtoList.add(StudentResponseDto.builder().studentCode(2).build());
        dtoList.add(StudentResponseDto.builder().studentCode(3).build());
        dtoList.add(StudentResponseDto.builder().studentCode(4).build());

        return new CMRespDto<>(1, "학생 정보 리스트입니다.", dtoList);
    }
}
