package com.example.demo.controller;

import com.example.demo.model.CodeSubVo;
import com.example.demo.security.config.LoginUserDetails;
import com.example.demo.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloWorldController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public ModelAndView helloWorld(){
        ModelAndView mav = new ModelAndView();

        mav.addObject("title", "hello");
        mav.addObject("result", "Hello world!");
        mav.setViewName("hello");

        return mav;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/tables")
    public String tables(
            ModelMap modelMap,
            @AuthenticationPrincipal LoginUserDetails userDetails
    ){

        modelMap.put("title", "tables");
        modelMap.put("result", helloWorldService.showTables());
        modelMap.put("memberIdx", userDetails.getMemberIdx());
        modelMap.put("id", userDetails.getUsername());

        return "hello";
    }

    @GetMapping("/get")
    public String get(ModelMap modelMap){

        modelMap.put("title", "get");
//        modelMap.put("result", helloWorldService.getTestJooq());
        modelMap.put("result", helloWorldService.getTest("1002"));


        return "hello";
    }

    @GetMapping("/logger")
    public String logger(){

        logger.trace("logback - trace");
        logger.debug("logback - debug");
        logger.info("logback - info");
        logger.warn("logback - warn");
        logger.error("logback - error");

        return "logger";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<CodeSubVo> postMappingId(){
        return helloWorldService.getTest("1002");
    }
}
