package com.example.demo.security.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class MemberInfoVo {
    private String memberIdx;
    private String id;
    private String passwd;
    private String name;
    private String email;
    private String celPhone;
    private String enabled;
    private String regDt;
    private String regIp;
    private String regMemberIdx;
    private String secedeDt;
    private String secedeIp;
    private String secedeMemberIdx;
    private String loginCnt;
    private String lastAccessTime;

//    private List<MemberGroupVo> memberGroupList;
    private String memberGroupListString;
}
