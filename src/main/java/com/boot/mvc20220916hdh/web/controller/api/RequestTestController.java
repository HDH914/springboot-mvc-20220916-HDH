package com.boot.mvc20220916hdh.web.controller.api;

import com.boot.mvc20220916hdh.web.dto.AddPostReqDto;
import com.boot.mvc20220916hdh.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class RequestTestController {
    //ResponseEntity가 없으면 그냥 데이터만 응답,
    //ResponseEntity가 있으면 Http프로토콜의 기능(헤더, 스테이터스 코드)까지 설정 가능


    @PostMapping("/rp/post")
    //@RequestParam 방식
    public ResponseEntity<?> addPost(@RequestParam String title,
                                     @RequestParam String writer,
                                     @RequestParam String content){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("writer", writer);
        map.put("content", content);

        return ResponseEntity
                .ok(new CMRespDto<>(1, "게시글 작성 완료", map));
    }


    @PostMapping("/dto/post")
    //Dto 방식
    public ResponseEntity<?> addPost(AddPostReqDto addPostReqDto){

        log.info("{}", addPostReqDto);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(1, "게시글 작성 완료", addPostReqDto));
    }

    @PostMapping("/file/post")
    //이미지는 form-data로
    public ResponseEntity<?> addPost2(AddPostReqDto addPostReqDto){

        log.info("{}", addPostReqDto);
        List<String> fileNames = new ArrayList<String>();

        String fileName1 = addPostReqDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);

        if(addPostReqDto.getFiles() != null) {
            String fileName2 = addPostReqDto.getFiles().get(0).getOriginalFilename();
            String fileName3 = addPostReqDto.getFiles().get(1).getOriginalFilename();
            fileNames.add(fileName2);
            fileNames.add(fileName3);
        }

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(1, "게시글 작성 완료", fileNames));
    }

    @PostMapping("/json/post")
    //Json 형식
    //put요청은 form-data형식을 사용할 수 없기때문에 수정할때 post방식 + RequestBody 를 사용
    //Json을 사용하시 위해서는 RequestBody가 필수
    public ResponseEntity<?> addPost3(@RequestBody AddPostReqDto addPostReqDto){

        log.info("{}", addPostReqDto);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(1, "Json으로 게시글 작성 완료", addPostReqDto));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id){
        log.info("삭제 할 게시글 번호: ({})", id);

        return ResponseEntity.ok(new CMRespDto<>(1, "삭제 성공", id));
    }
}
