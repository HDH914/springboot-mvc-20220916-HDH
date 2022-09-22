package com.boot.mvc20220916hdh.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddNewsReqDto {
    private String title;
    private String broadcastinhName;
    private List<MultipartFile> files;
    private String content;
}
