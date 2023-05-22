package com.masai.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       Authentication auth =  SecurityContextHolder.getContext().getAuthentication();

       if(auth != null){

           SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

           String jwt = Jwts.builder()
                   .setIssuer("Bus Reservation")
                   .setSubject("Jwt Token")
                   .claim("username" , auth.getName())
                   .claim("role" , getRole(auth.getAuthorities()))
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(new Date().getTime()+30000000)) // expire 8 hour
                   .signWith(key).compact();


           response.setHeader(SecurityConstants.JWT_HEADER , jwt);

       }

       filterChain.doFilter(request , response);



    }

    private String getRole(Collection<? extends GrantedAuthority> collation){

        String role = "";

        for(GrantedAuthority el : collation){

                role = el.getAuthority();
            }

            return role;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{

        return !request.getServletPath().equals("/signIn");
    }
}
