package com.pweb.pw_api_u3_ab.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    @Value("$app.jwt.secret") // inyecta los valores desde el propetties
    private String jwtSecreat; // semilla

    public boolean validateJwtToken(String token) {

        Jwts.parser().setSigningKey(jwtSecreat).parseClaimsJws(token);

        return true;
    }

}
