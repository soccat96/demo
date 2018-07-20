package com.example.demo.security.service;

import com.example.demo.security.dao.MemberInfoDao;
import com.example.demo.security.model.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoDao memberInfoDao;

    @Override
    public void insertMemberInfo(MemberInfoVo memberInfoVo) {
        memberInfoDao.insertMemberInfo(memberInfoVo);
    }

    @Override
    public MemberInfoVo selectOneMemberInfo(MemberInfoVo memberInfoVo) {
        return memberInfoDao.selectOneMemberInfo(memberInfoVo);
    }

    @Override
    public List<MemberInfoVo> selectMemberInfo(MemberInfoVo memberInfoVo) {
        return memberInfoDao.selectMemberInfo(memberInfoVo);
    }
}
