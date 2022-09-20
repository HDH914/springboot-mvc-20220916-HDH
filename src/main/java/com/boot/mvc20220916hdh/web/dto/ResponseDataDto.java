package com.boot.mvc20220916hdh.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDataDto {
    private String value1;
    private int value2;
    private Boolean value3;
}
