package com.zeneo.tmsdemo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {


    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            token = authHeader.substring(7);

        } else {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = authenticate(token);

        if (usernamePasswordAuthenticationToken != null) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        chain.doFilter(request, response);
        return;
    }

    private UsernamePasswordAuthenticationToken authenticate(String token) {
        if (token != null) {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("49652dsdkljfsdmcvdfgsdsffgfd458sdkd")).build().verify(token);
            String user = decodedJWT.getSubject();
            String role = decodedJWT.getClaim("role").asString();
            if (user != null) {

                return new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList(role));
            } else
                return null;
        } else
            return null;
    }

}
