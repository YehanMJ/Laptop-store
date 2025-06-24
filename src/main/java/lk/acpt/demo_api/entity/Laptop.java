package lk.acpt.demo_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private int ram;
    private String serial;

    @OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL)
    List<Charger> chargers;

    public Laptop(Integer id, String brand, String model, int ram, String serial) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.serial = serial;
    }
}
