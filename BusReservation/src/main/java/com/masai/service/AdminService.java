package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {

    public Admin registerAdmin(Admin admin) throws AdminException;
}
