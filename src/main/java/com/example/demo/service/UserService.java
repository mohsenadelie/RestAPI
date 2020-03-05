package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserRequestDTO;
import com.example.demo.domain.dto.UserResponseDTO;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    // Logic

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(UserRequestDTO dto) {
//        User user = new User(
//                (Long) counter.incrementAndGet(),
//                dto.getFirstName(),
//                dto.getFamilyName(),
//                dto.getGender(),
//                dto.getBirthDate());

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getFamilyName());
        user.setGender(dto.getGender());
        user.setBirthDate(dto.getBirthDate());

        repository.save(user);

        return user;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public UserResponseDTO getById(Long id) throws Exception {
        UserResponseDTO dto;

        Optional<User> u = repository.findById(id);

        if (u.isPresent()) {
            dto = new UserResponseDTO(
                    u.get().getFirstName() + " " + u.get().getLastName(),
                    u.get().getGender(),
                    u.get().getBirthDate()
            );
            return dto;
        } else {
            throw new Exception("not found");
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
