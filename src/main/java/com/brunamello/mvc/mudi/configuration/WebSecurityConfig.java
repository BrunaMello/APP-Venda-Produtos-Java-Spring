package com.brunamello.mvc.mudi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/static/js/**").permitAll()
                .antMatchers("/static/styles/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                )
                .logout(logout -> logout.logoutUrl("/logout"));
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                .username("bruna")
                .password("bruna")
                .roles("ADM")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
