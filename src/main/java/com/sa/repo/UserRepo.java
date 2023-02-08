package com.sa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
