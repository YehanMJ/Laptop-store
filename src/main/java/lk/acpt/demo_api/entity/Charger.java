package lk.acpt.demo_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    double watt;
    long wirelength;
    String brand;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    Laptop laptop;
}
