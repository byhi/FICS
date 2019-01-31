package com.byhi.fics.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


    @EnableGlobalMethodSecurity(securedEnabled = true)
    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("byhi")
                .password("1234")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Override
    public void configure(HttpSecurity httpSec) throws Exception {
        httpSec
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").permitAll() .antMatchers("/h2_console/**").permitAll();;
    }*/
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/", "/home").permitAll()
               .antMatchers("/admin", "/h2_console/**").hasRole("ADMIN").anyRequest()
               .authenticated()
               .and()
               .formLogin().loginPage("/login").permitAll()
               .and()
               .logout().permitAll();
       http.exceptionHandling().accessDeniedPage("/403");
       http.csrf().disable();
       http.headers().frameOptions().disable();
   }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}user").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}admin").roles("ADMIN");
        }
}
