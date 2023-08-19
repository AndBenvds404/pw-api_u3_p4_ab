package com.pweb.pw_api_u3_ab.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    private static final Logger LOG = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Autenticar si el token es valido
        LOG.info(this.parseJwt(request));
        try {
            String jwt = this.parseJwt(request);
            // q no sea nullo el token y sea valido
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                // como es valido el token le voy a autenticar
                String nombre = this.jwtUtils.getUsernameFromJwtToken(jwt);

                // le autenticamos

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(nombre,
                        null,
                        new ArrayList<>());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));// se ejecuta la
                                                                                                      // authtenticacion
                                                                                                      // dentro del
                                                                                                      // filtro
                // seteamos la autenticacion en la session
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        } catch (Exception e) {
            // TODO: handle exception

            LOG.error("No se pudo realizar la autenticacion con el token ENVIADO {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {

        String valorCompleto = request.getHeader("Authorization");
        if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer ")) { // valida que se aun texto y
                                                                                         // empieze con Bearer
            return valorCompleto.substring(7, valorCompleto.length());
        }
        return null;

    }

}
