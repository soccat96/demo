package com.example.demo.service;

import com.example.demo.dao.TestDao;
import com.example.demo.model.CodeSubVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    private TestDao testDao;

    public List<String> showTables() { return testDao.showTables(); }

    public List<String> getTestJooq() {
        return testDao.getTestJooq();
    }

    public List<CodeSubVo> getTest(String mainCd) {
        return testDao.getTest(mainCd);
    }
}
