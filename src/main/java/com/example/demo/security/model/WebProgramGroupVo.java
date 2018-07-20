package com.example.demo.security.model;

import lombok.Data;

@Data
public class WebProgramGroupVo {
    private String groupId;
    private String webPrdId;
    private String regDt;
    private String regIp;
    private String regMemberIdx;
    private String urlPattern;
    private String groupNm;
    private String webProgramGroupListString;

}
