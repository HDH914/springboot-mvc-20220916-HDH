package com.boot.mvc20220916hdh.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class StudentResponseDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;

}
