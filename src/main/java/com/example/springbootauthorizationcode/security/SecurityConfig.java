package com.example.springbootauthorizationcode.security;

import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

import static org.springframework.security.config.Customizer.withDefaults;


public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter { //2


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) { //4
        auth.authenticationProvider(getKeycloakAuthenticationProvider());
    }

    private KeycloakAuthenticationProvider getKeycloakAuthenticationProvider() { //5
        KeycloakAuthenticationProvider authenticationProvider = keycloakAuthenticationProvider();
        var mapper = new SimpleAuthorityMapper();
        mapper.setConvertToUpperCase(true);
        authenticationProvider.setGrantedAuthoritiesMapper(mapper);

        return authenticationProvider;
    }



    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() { //6
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }


}