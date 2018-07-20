package com.example.demo.dao;

import com.example.demo.model.CodeSubVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("testDao")
public interface TestDao {
    List<String> showTables();

    List<String> getTestJooq();

    List<CodeSubVo> getTest(String mainCd);
}
