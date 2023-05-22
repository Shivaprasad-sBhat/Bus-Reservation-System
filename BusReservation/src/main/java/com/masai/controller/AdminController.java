package com.masai.controller;

import com.masai.model.Admin;
import com.masai.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){

           admin.setRole("ROLE_ADMIN");

           admin.setPassword(passwordEncoder.encode(admin.getPassword()));

           Admin ad =    adminService.registerAdmin(admin);

           return new ResponseEntity<Admin>(ad , HttpStatus.ACCEPTED);
    }

}
