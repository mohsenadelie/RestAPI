package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.MyResponse;
import com.example.demo.domain.dto.UserRequestDTO;
import com.example.demo.domain.dto.UserResponseDTO;
import com.example.demo.service.UserService;
import com.example.demo.controller.validator.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

// 1- It is a Bean
// 2- It is a controller class  => GET, POST, PUT, DELETE
@RestController
public class UserController {

    private final UserService service;
    private final UserValidator validator;

    public UserController(UserService service, UserValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    // GET
    @GetMapping("/users/{id}")
    public ResponseEntity<MyResponse> getUser(@PathVariable(name = "id") Long id) {
        MyResponse mrs = new MyResponse();
        try {
            UserResponseDTO dto = service.getById(id);
            mrs.setBody(dto);
        } catch (Exception e) {
            mrs.setErrorMessage("User not found!");
        }
        return new ResponseEntity(mrs, HttpStatus.OK);
    }

    // GET
    @GetMapping("/users")
    public ResponseEntity<MyResponse> getUsers() {
        MyResponse mrs = new MyResponse();
        List<User> users = service.getAll();
        mrs.setBody(users);
        return new ResponseEntity(mrs, HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<MyResponse> createUser(@RequestBody UserRequestDTO dto) {
        MyResponse mrs = new MyResponse();

        try {
            validator.isValid(dto);
            mrs.setBody(service.createUser(dto));
        } catch (Exception e) {
            mrs.setErrorMessage("your birth date is not valid");
            return new ResponseEntity(mrs, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(mrs, HttpStatus.OK);
    }

    // PUT
    @PutMapping("/users")
    public ResponseEntity<MyResponse> updateUser() {
        MyResponse mrs = new MyResponse();

        mrs.setBody("User successfully updated");
        return new ResponseEntity(mrs, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/users")
    public ResponseEntity<MyResponse> deleteUser(Long id) {
        MyResponse mrs = new MyResponse();
//        mrs.setBody(service.delete(id));

        mrs.setBody("User successfully deleted!");
        return new ResponseEntity(mrs, HttpStatus.OK);
    }

}
