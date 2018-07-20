package com.example.demo.security.model;

import lombok.Data;

@Data
public class ProgramInfoVo {
    private String programId;
    private String programNm;
    private String programDesc;
    private String regDt;
    private String regIp;
    private String regMemberIdx;
    private String viewOrder;
}
