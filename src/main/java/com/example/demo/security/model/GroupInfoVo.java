package com.example.demo.security.model;

import lombok.Data;

@Data
public class GroupInfoVo {
    private String groupId;
    private String groupNm;
    private String groupDesc;
    private String regDt;
    private String regIp;
    private String regMemberIdx;
}
