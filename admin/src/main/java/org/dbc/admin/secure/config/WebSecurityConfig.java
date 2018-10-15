package org.dbc.admin.secure.config;

import org.dbc.admin.secure.handle.AjaxLogoutSuccessHandler;
import org.dbc.admin.secure.handle.AuthenticationAccessDeniedHandler;
import org.dbc.admin.secure.handle.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:26
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserServiceImpl")
    private CustomUserService customUserService;

    @Autowired
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied"))
                .and()
                .formLogin()
                .loginProcessingUrl("/admin/login")
                .successForwardUrl("/admin/welcome")
                .usernameParameter("email")
                .passwordParameter("passwordHash")
                .failureForwardUrl("/admin/loginFail")
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                // Do not need authentication
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/management/health").permitAll()
                .antMatchers("/management/**").permitAll()
                // Need authentication
                .antMatchers("/error/**").permitAll()
                .antMatchers("/**").permitAll();

    }
}