package com.example.demo.security.model;

import lombok.Data;

@Data
public class WebProgramInfoVo {
    private String webPrdId;
    private String webPrdNm;
    private String urlPattern;
    private String regDt;
    private String regIp;
    private String regMemberIdx;
    private String viewOrder;
    private String topMenuViewYn;

    private String programGroupListString;
}
