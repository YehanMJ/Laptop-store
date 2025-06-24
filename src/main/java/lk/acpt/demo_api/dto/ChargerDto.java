package lk.acpt.demo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargerDto {
    private Integer id;
    private double watt;
    private long wireLength;
    private String brand;
    private LaptopDto laptop;

    public ChargerDto(Integer id, double watt, long wirelength, String brand) {
        this.id = id;
        this.watt = watt;
        this.wireLength = wirelength;
        this.brand = brand;
    }
}
