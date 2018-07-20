package com.example.demo.security.config;

import com.example.demo.security.dao.GroupInfoDao;
import com.example.demo.security.dao.MemberInfoDao;
import com.example.demo.security.dao.WebProgramInfoDao;
import com.example.demo.security.model.WebProgramGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    private UserDetailsService loginUserDetailsService;

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        //resource
        webSecurity.ignoring().antMatchers("/resource/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();


//        httpSecurity.authorizeRequests()
//                .antMatchers("/", "/index").permitAll()
//                .antMatchers("/tables/**").hasAnyRole("ADMIN")
//                .antMatchers("/get/**").hasAnyRole("NORMAL")
//                .anyRequest().authenticated();

        httpSecurity.addFilter(filterSecurityInterceptor());
        httpSecurity.authorizeRequests().antMatchers("/", "/index").permitAll();

        httpSecurity.exceptionHandling().accessDeniedPage("/denied");

        httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.formLogin()
//                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll();

        httpSecurity.logout()
//                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();

//        httpSecurity.formLogin().loginProcessingUrl("/login");
//        httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Configuration
//    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//        @Autowired
//        private UserDetailsService loginUserDetailsService;
//
//
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
//        }
//    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RoleVoter roleVoter() {
        RoleVoter roleVoter = new RoleVoter();

        roleVoter.setRolePrefix("ROLE_");

        return roleVoter;
    }

    @Bean
    public AffirmativeBased affirmativeBased() {
        List<AccessDecisionVoter<? extends Object>> accessDecisionVoters = new ArrayList<>();

        accessDecisionVoters.add(roleVoter());

        return new AffirmativeBased(accessDecisionVoters);
    }

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor() {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();

        filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        filterSecurityInterceptor.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
        filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased());

        return filterSecurityInterceptor;
    }

    @Bean
    public FilterMetadataSource filterMetadataSource() { return new FilterMetadataSource(); }
}
