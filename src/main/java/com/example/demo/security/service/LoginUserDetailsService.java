package com.example.demo.security.service;

import com.example.demo.security.config.LoginUserDetails;
import com.example.demo.security.model.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("loginUserDetailsService")
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberInfoService memberInfoService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        MemberInfoVo memberInfoVoParams = new MemberInfoVo();
        memberInfoVoParams.setId(id);
        MemberInfoVo memberInfoVo = memberInfoService.selectOneMemberInfo(memberInfoVoParams);

        if(memberInfoVo == null){
            throw new UsernameNotFoundException("Cannot find id");
        }

        return new LoginUserDetails(memberInfoVo);
    }
}
