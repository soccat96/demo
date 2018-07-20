package com.example.demo.security.dao;

import com.example.demo.security.model.WebProgramGroupVo;
import com.example.demo.security.model.WebProgramInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("webProgramInfoDao")
public interface WebProgramInfoDao {

    List<WebProgramInfoVo> selectWebProgramInfoDao(WebProgramInfoVo webProgramInfoVo);

    List<WebProgramGroupVo> getListWebProgramGroup();

    List<WebProgramGroupVo> webGroupTest(WebProgramInfoVo webProgramInfoVo);
}
