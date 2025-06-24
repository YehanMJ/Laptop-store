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
public class UserDtoReturn {
    private String email;
    private String status;
}
