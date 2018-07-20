package com.example.demo.security.service;

import com.example.demo.security.model.MemberInfoVo;

import java.util.List;

public interface MemberInfoService {
    void insertMemberInfo(MemberInfoVo memberInfoVo);

    MemberInfoVo selectOneMemberInfo(MemberInfoVo memberInfoVo);

    List<MemberInfoVo> selectMemberInfo(MemberInfoVo memberInfoVo);
}
