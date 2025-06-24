package lk.acpt.demo_api.service.impl;

import lk.acpt.demo_api.dto.ChargerDto;
import lk.acpt.demo_api.dto.LaptopDto;
import lk.acpt.demo_api.dto.LaptopWithChargerDto;
import lk.acpt.demo_api.entity.Charger;
import lk.acpt.demo_api.entity.Laptop;
import lk.acpt.demo_api.repo.LaptopRepo;
import lk.acpt.demo_api.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 4/28/2025
 **/
@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepo laptopRepo;

    @Autowired
    public LaptopServiceImpl(LaptopRepo laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    @Override
    public LaptopDto saveLaptop(LaptopDto laptopDto) {
        Laptop save = laptopRepo.save(new Laptop(null, laptopDto.getBrand(), laptopDto.getModel(), laptopDto.getRam(), laptopDto.getSerial()));
        return new LaptopDto(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getSerial());
    }

    @Override
    public LaptopDto getLaptopById(Integer id) {
        Optional<Laptop> byId = laptopRepo.findById(id);
        if(byId.isPresent()) {
            Laptop laptop = byId.get();
            return new LaptopDto(laptop.getId(), laptop.getBrand(), laptop.getModel(), laptop.getRam(), laptop.getSerial());
        }
        return null;
    }

    @Override
    public LaptopDto updateLaptop(LaptopDto laptopDto) {
        Optional<Laptop> byId = laptopRepo.findById(laptopDto.getId());
        if(byId.isPresent()) {
            Laptop laptop = byId.get();
            laptop.setBrand(laptopDto.getBrand());
            laptop.setModel(laptopDto.getModel());
            laptop.setRam(laptopDto.getRam());
            laptop.setSerial(laptopDto.getSerial());
            Laptop save = laptopRepo.save(laptop);

            return new LaptopDto(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getSerial());
        }
        return null;
    }

    @Override
    public LaptopDto deleteLaptop(Integer id) {
        Optional<Laptop> byId = laptopRepo.findById(id);
        if (byId.isPresent()) {
            laptopRepo.deleteById(id);
            return new LaptopDto(byId.get().getId(),byId.get().getBrand(),byId.get().getModel(),byId.get().getRam(),byId.get().getSerial());
        }
        return null;
    }

    @Override
    public List<LaptopDto> getAllLaptops() {
        List<Laptop> all = laptopRepo.findAll();
        List<LaptopDto> laptopDtos = new ArrayList<>();
        for (Laptop laptop : all) {
            laptopDtos.add(new LaptopDto(laptop.getId(),laptop.getBrand(),laptop.getModel(),laptop.getRam(),laptop.getSerial()));
        }
        return laptopDtos;
    }

    @Override
    public LaptopWithChargerDto saveLapWithCharger(LaptopWithChargerDto laptopWithChargerDto) {
        Laptop laptop = new Laptop(null, laptopWithChargerDto.getBrand(),
                laptopWithChargerDto.getModel(), laptopWithChargerDto.getRam(), laptopWithChargerDto.getSerial());

        List<Charger> chargers = new ArrayList<>();

        for(ChargerDto chargerDto : laptopWithChargerDto.getChargers()) {
            chargers.add(new Charger(chargerDto.getId(),
                    chargerDto.getWatt(),
                    chargerDto.getWireLength(),
                    chargerDto.getBrand(), laptop));
        }

        laptop.setChargers(chargers);
        Laptop save = laptopRepo.save(laptop);
        LaptopDto laptopDto = new LaptopDto(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getSerial());

        List<ChargerDto> chargerDtosDto = new ArrayList<>();
        for(Charger charger : save.getChargers()) {
            chargerDtosDto.add(new ChargerDto(charger.getId(),charger.getWatt(), charger.getWirelength(), charger.getBrand(), laptopDto));
        }
        return new LaptopWithChargerDto(save.getId(), save.getBrand(), save.getModel(), save.getRam(), save.getSerial(), chargerDtosDto);
    }

    @Override
    public List<LaptopWithChargerDto> getAllLapWithChargers() {
        List<Laptop> all = laptopRepo.findAll();
        List<LaptopWithChargerDto> laptopWithChargerDtos = new ArrayList<>();
        List<ChargerDto> chargerDtos = new ArrayList<>();
        for (Laptop laptop : all) {
            for (Charger charger : laptop.getChargers()) {
                chargerDtos.add(new ChargerDto(charger.getId(), charger.getWatt(), charger.getWirelength(), charger.getBrand()));
            }
            laptopWithChargerDtos.add(new LaptopWithChargerDto(laptop.getId(), laptop.getBrand(), laptop.getModel(),
                    laptop.getRam(), laptop.getSerial(), chargerDtos));
        }
        return laptopWithChargerDtos;
    }


}
