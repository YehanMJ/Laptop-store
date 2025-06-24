package lk.acpt.demo_api.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/7/2025
 **/
public interface StorageService {
    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
