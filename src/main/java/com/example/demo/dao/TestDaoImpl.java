package com.example.demo.dao;

import com.example.demo.model.CodeSubVo;
import org.apache.ibatis.session.SqlSession;
import org.jooq.DSLContext;
import org.jooq.types.UShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.jooq.tables.CodeSub.CODE_SUB;

@Component
//public class TestDaoImpl implements TestDao{
public class TestDaoImpl{

    @Autowired
    private SqlSession sqlSession;

//    @Override
//    public List<String> showTables() {
//        return sqlSession.selectList("mapper.TestMapper.showTables");
//    }
//
//    @Autowired
//    private DSLContext dslContext;
//
//    public List<String> getTestJooq(){
//        return dslContext
//                .selectFrom(CODE_SUB)
//                .where(CODE_SUB.MAIN_CD.eq(UShort.valueOf("1003")))
//                .fetch(CODE_SUB.SUB_CD_NM);
//    }
//
//    @Override
//    public List<CodeSubVo> getTest(String mainCd) {
//        return sqlSession.selectList("mapper.TestMapper.getTest", mainCd);
//    }
}
