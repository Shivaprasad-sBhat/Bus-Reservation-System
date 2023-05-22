package com.masai.service;

import com.masai.model.Admin;
import com.masai.repository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AdminCustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AdminDao aDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("admin provider");

        String userName = authentication.getName();

        String password = authentication.getCredentials().toString();

        Optional<Admin> adminExist = aDao.findByName(userName);

        if(adminExist.isPresent()){

            Admin admin = adminExist.get();

            if(passwordEncoder.matches(password , admin.getPassword())) {


                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

                grantedAuthorityList.add(new SimpleGrantedAuthority(admin.getRole()));

                return new UsernamePasswordAuthenticationToken(userName , password , grantedAuthorityList);

            }

            else throw new BadCredentialsException("Password is wrong");

        }

        else throw new BadCredentialsException("Admin not exist");

    }

    @Override
    public boolean supports(Class<?> authentication) {


        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
