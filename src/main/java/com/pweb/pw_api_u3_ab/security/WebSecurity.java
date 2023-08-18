package com.pweb.pw_api_u3_ab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        http.addFilterBefore(null, null);

        return http.build();

    }

}
