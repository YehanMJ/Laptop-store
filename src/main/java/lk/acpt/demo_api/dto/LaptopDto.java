package lk.acpt.demo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDto{
    private int id;
    private String brand;
    private String model;
    private int ram;
    private String serial;
}
