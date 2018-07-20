package com.example.demo.security.config;

import com.example.demo.security.dao.WebProgramInfoDao;
import com.example.demo.security.model.WebProgramGroupVo;
import com.example.demo.security.model.WebProgramInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class FilterMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private WebProgramInfoDao webProgramInfoDao;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return getAttributesByUrl(((FilterInvocation) o).getRequestUrl());
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    private List<ConfigAttribute> getAttributesByUrl(String requestUrl) {
        ArrayList<ConfigAttribute> configAttributes = new ArrayList<>();

        WebProgramInfoVo webProgramInfoVo = new WebProgramInfoVo();
        System.out.println("requestUrl::==" + requestUrl);
        webProgramInfoVo.setUrlPattern(requestUrl);
        List<WebProgramGroupVo> webProgramGroupVoList = webProgramInfoDao.webGroupTest(webProgramInfoVo);
        for(WebProgramGroupVo x : webProgramGroupVoList){
            ConfigAttribute configAttribute = new CustomConfigAttribute(x.getGroupNm());
            configAttributes.add(configAttribute);
        }

        return configAttributes;
    }

    private class CustomConfigAttribute implements ConfigAttribute {
        private String attribute;

        public CustomConfigAttribute(String attribute) {
            this.attribute = attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public String getAttribute() {
            return this.attribute;
        }
    }
}
