package com.example.obspringsecuritycifrado.repository;

import com.example.obspringsecuritycifrado.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}


