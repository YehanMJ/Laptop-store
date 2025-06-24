package lk.acpt.demo_api.service;

import lk.acpt.demo_api.dto.LaptopDto;
import lk.acpt.demo_api.dto.LaptopWithChargerDto;
import lk.acpt.demo_api.entity.Laptop;

import java.util.List;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
public interface LaptopService {
    LaptopDto saveLaptop (LaptopDto laptopDto);
    LaptopDto getLaptopById(Integer id);
    LaptopDto updateLaptop(LaptopDto laptopDto);
    LaptopDto deleteLaptop(Integer id);
    List<LaptopDto> getAllLaptops();
    LaptopWithChargerDto saveLapWithCharger(LaptopWithChargerDto laptopWithChargerDto);
    List<LaptopWithChargerDto> getAllLapWithChargers();

}
