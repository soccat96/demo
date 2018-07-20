package com.example.demo.security.dao;

import com.example.demo.security.model.MemberInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("memberInfoDao")
public interface MemberInfoDao {
    void insertMemberInfo(MemberInfoVo memberInfoVo);

    MemberInfoVo selectOneMemberInfo(MemberInfoVo memberInfoVo);

    List<MemberInfoVo> selectMemberInfo(MemberInfoVo memberInfoVo);
}
