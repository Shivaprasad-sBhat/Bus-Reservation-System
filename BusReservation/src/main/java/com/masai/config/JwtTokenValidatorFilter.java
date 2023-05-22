package com.masai.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenValidatorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


       String jwt =  request.getHeader(SecurityConstants.JWT_HEADER);

       if(jwt != null){

           try{

                // remove the Bearer from jwt we need take substring
               jwt = jwt.substring(7);


               SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

               Claims claim = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

               String userName = String.valueOf(claim.get("username"));

               String role = (String) claim.get("role");

               List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

               grantedAuthorityList.add(new SimpleGrantedAuthority(role));

               Authentication auth = new UsernamePasswordAuthenticationToken(userName , null, grantedAuthorityList);

               SecurityContextHolder.getContext().setAuthentication(auth);

           }
           catch (Exception ex){

               throw new BadCredentialsException(ex.getMessage());
           }

                filterChain.doFilter(request , response);
       }

    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){

        return request.getServletPath().equals("/signIn") || request.getServletPath().equals("/createUser") || request.getServletPath().equals("/admin/register");
    }
}
