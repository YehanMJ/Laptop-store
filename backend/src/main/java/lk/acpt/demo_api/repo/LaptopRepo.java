package lk.acpt.demo_api.repo;

import lk.acpt.demo_api.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {
}
