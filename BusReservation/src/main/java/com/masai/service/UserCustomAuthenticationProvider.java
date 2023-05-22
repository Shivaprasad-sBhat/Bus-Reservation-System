package com.masai.service;

import com.masai.model.Customer;
import com.masai.model.User;
import com.masai.repository.CustomerDao;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserCustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private CustomerDao cDao;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("user auth provider");

        String username = authentication.getName();

        String password = authentication.getCredentials().toString();


        Optional<Customer> customerExist = cDao.findByName(username);

        if(customerExist.isPresent()){

            User user = customerExist.get();

            if(passwordEncoder.matches(password , user.getPassword())){


                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

                SimpleGrantedAuthority sg = new SimpleGrantedAuthority(user.getRole());

                grantedAuthorityList.add(sg);

                return new UsernamePasswordAuthenticationToken(username , password , grantedAuthorityList);


            }

            else throw new BadCredentialsException("Password is wrong");

        }

        else throw new BadCredentialsException("Customer is not exist ...!");







    }

    @Override
    public boolean supports(Class<?> authentication) {

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
