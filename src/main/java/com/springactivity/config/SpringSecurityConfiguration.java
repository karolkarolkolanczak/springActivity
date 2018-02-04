package com.springactivity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by a on 03/02/2018.
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles( "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
        http
            .authorizeRequests()
                .antMatchers("/products**/**","/productForm**/**","/productEdit**/**")
                .authenticated()
                .and()
            .authorizeRequests()
                .antMatchers("/","/loginForm","logout")
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/static/css/**","/js/**", "/images/**", "/**/favicon.ico")
                .permitAll()
                .and()
            .formLogin()
                .loginPage("/loginForm")
                .defaultSuccessUrl("/products")
                .failureUrl("/login-error")
                .permitAll()
                .and()
            .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
