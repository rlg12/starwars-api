package com.starwars.config;

import com.starwars.auth.FakeAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by rlg12 on 14/07/17.
 */
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
    private FakeAuthProvider authentificationProvider;

    @Autowired
    public SecurityConfiguration(FakeAuthProvider authentificationProvider ){
        super();
        this.authentificationProvider = authentificationProvider;;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
        auth.authenticationProvider(authentificationProvider);
    }

}
