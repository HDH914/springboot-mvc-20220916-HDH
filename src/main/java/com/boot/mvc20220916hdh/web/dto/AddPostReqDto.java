package com.boot.mvc20220916hdh.web.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class AddPostReqDto {
    private String title;
    private String writer;
    private String content;
    private MultipartFile file;    //파일은 MultipartFile 타입을 사용
    private List<MultipartFile> files;
}
