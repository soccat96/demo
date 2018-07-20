package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class CodeSubVo {
    private String mainCd;
    private String subCd;
    private String subCdNm;
}
