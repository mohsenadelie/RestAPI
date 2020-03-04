package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    // Logic
    List<User> users = new ArrayList<>();
    AtomicLong counter = new AtomicLong();

    public User createUser(UserRequestDTO dto) {
//        User user = new User(
//                (Long) counter.incrementAndGet(),
//                dto.getFirstName(),
//                dto.getFamilyName(),
//                dto.getGender(),
//                dto.getBirthDate());

        User user = new User();

        user.setId((Long) counter.incrementAndGet());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getFamilyName());
        user.setGender(dto.getGender());
        user.setBirthDate(dto.getBirthDate());

        users.add(user);

        return user;
    }
}
