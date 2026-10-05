package com.Carrental.car.Repositry;

import com.Carrental.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Userrepositry extends JpaRepository<User, UUID> {

   org.springframework.security.core.userdetails.User findByName(String name);

}