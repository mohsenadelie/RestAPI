package com.example.demo.controller.validator;

import com.example.demo.domain.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserValidator {

    public void isValid(UserRequestDTO dto) throws Exception {
        if (!dto.getBirthDate().isBefore(LocalDate.now())) {
            throw new Exception();
        }
    }

}
