package com.pweb.pw_api_u3_ab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurity {

    @Autowired
    private AuthEntryPointJwt unAutorizedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()// desbilitar el cors
                .exceptionHandling().authenticationEntryPoint(unAutorizedHandler)// manego de no autorizados
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().anyRequest()
                .authenticated();

        http.addFilterBefore(this.AuthenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    public AuthTokenFilter AuthenticationJwtTokenFilter() {

        return new AuthTokenFilter();
    }

}
