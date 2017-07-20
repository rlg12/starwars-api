package com.starwars.config;

import com.starwars.auth.FakeAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by rlg12 on 14/07/17.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
    private FakeAuthProvider authentificationProvider;

    @Autowired
    public SecurityConfiguration(FakeAuthProvider authentificationProvider ){
        super();
        this.authentificationProvider = authentificationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
        auth.authenticationProvider(authentificationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/films**").permitAll()
                .antMatchers("/planets**").hasRole("ADMIN")
                .antMatchers("/peoples**").authenticated();
    }

}
