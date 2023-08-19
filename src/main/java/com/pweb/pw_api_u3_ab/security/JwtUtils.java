package com.pweb.pw_api_u3_ab.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    @Value("$app.jwt.secret") // inyecta los valores desde el propetties
    private String jwtSecreat; // semilla

    public boolean validateJwtToken(String token) {

        try {
            Jwts.parser().setSigningKey(jwtSecreat).parseClaimsJws(token);

        } catch (ExpiredJwtException e) {
            // TODO: handle exception
            LOG.error(e.getMessage());
        } catch (SignatureException e) {
            LOG.error(e.getMessage());
        }

        return false;
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecreat).parseClaimsJws(token).getBody().getSubject();
    }

}
