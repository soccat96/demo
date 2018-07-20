package com.example.demo.security.config;

import com.example.demo.security.model.MemberInfoVo;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class LoginUserDetails extends User {

    @Getter
    private String memberIdx;

    public LoginUserDetails(MemberInfoVo memberInfoVo){
        super(
                memberInfoVo.getId(),
                memberInfoVo.getPasswd(),
                AuthorityUtils.createAuthorityList(memberInfoVo.getMemberGroupListString().split(","))
        );
        memberIdx = memberInfoVo.getMemberIdx();
    }

}
