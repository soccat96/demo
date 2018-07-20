package com.example.demo.security.dao;

import com.example.demo.security.model.GroupInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("groupInfoDao")
public interface GroupInfoDao {

    List<GroupInfoVo> selectGroupInfp(GroupInfoVo groupInfoVo);
}
