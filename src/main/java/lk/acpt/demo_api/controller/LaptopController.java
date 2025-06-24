package lk.acpt.demo_api.controller;

import lk.acpt.demo_api.dto.LaptopDto;
import lk.acpt.demo_api.dto.LaptopWithChargerDto;
import lk.acpt.demo_api.service.LaptopService;
import lk.acpt.demo_api.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
@CrossOrigin
@RequestMapping("/api/v1/laptop")
@RestController
public class LaptopController {

    private static LaptopService laptopService;
    private final JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    public LaptopController(LaptopService laptopService, JWTTokenGenerator jwtTokenGenerator) {
        LaptopController.laptopService = laptopService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping
    public ResponseEntity<LaptopDto> saveLaptop(@RequestBody LaptopDto laptopDto, @RequestHeader(name = "Authorization") String authorizationHeader) {
        if(this.jwtTokenGenerator.verifyToken(authorizationHeader)) {
            LaptopDto dto = laptopService.saveLaptop(laptopDto);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping
    public ResponseEntity<List<LaptopDto>> getAllLaptops() {
        List<LaptopDto> dtos = laptopService.getAllLaptops();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LaptopDto> deleteLaptop(@PathVariable Integer id) {
        LaptopDto dto = laptopService.deleteLaptop(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDto> getLaptopById(@PathVariable Integer id) {
        LaptopDto dto = laptopService.getLaptopById(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaptopDto> updateLaptop(@RequestBody Integer id, @RequestBody LaptopDto laptopDto) {
        laptopDto.setId(id);
        LaptopDto dto = laptopService.updateLaptop(laptopDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/save_with_chargers")
    public ResponseEntity<LaptopWithChargerDto> saveLapWithChargers(@RequestBody LaptopWithChargerDto laptopWithChargerDto) {
        LaptopWithChargerDto laptopWithChargerDto1 = laptopService.saveLapWithCharger(laptopWithChargerDto);
        if (laptopWithChargerDto1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(laptopWithChargerDto1, HttpStatus.CREATED);
    }

    @GetMapping("/chargers")
    public ResponseEntity<List<LaptopWithChargerDto>> getLapsWithChargers(){
        List<LaptopWithChargerDto> allLapWithChargers = laptopService.getAllLapWithChargers();
        return new ResponseEntity<>(allLapWithChargers, HttpStatus.OK);
    }
}
