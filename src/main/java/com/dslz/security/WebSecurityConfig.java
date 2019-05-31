package com.dslz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("abc@gmail.com").password("admin123").roles("ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login.css", "/login.html", "/createUser.html")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            //.loginPage("/login.html")
            .permitAll();
    //     http
    //   .formLogin().loginPage("/partials/login.html").and()
    //   .authorizeRequests()
    //     .antMatchers("/login.html", "/#/login.html", "/index.html", "/#/index", "/#/index.html", "/#/login").permitAll().anyRequest()
    //     .authenticated();
    }

}