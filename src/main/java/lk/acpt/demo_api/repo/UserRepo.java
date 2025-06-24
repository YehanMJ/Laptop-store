package lk.acpt.demo_api.repo;

import lk.acpt.demo_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail(String email);
}
