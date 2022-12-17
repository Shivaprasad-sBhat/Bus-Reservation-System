package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Reservation;
import com.masai.model.User;

public interface UserDao  extends JpaRepository<User, Integer>{
//

}
