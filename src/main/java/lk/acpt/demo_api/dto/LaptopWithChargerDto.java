package lk.acpt.demo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopWithChargerDto {
    private Integer id;
    private String brand;
    private String model;
    private int ram;
    private String serial;
    private List<ChargerDto> chargers;
}
