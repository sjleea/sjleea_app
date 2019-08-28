package com.lsis.sjleea.sjleeaApp;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        /*
        http.cors().and().csrf().disable()
                .authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint()).authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionAuthenticationStrategy(SessionAuthenticationStrategy()).
         */

        http
                .exceptionHandling()
                .and()
                .formLogin()
                .and()
                .authorizeRequests().antMatchers("/actuator", "/aectuator/**").authenticated()
                .and()
                .logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder().encode("password")).roles("USER");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

