package com.example.demo.domain.dto;

import com.example.demo.domain.Gender;
import com.example.demo.domain.User;

import java.time.LocalDate;

public class UserRequestDTO {
    private String firstName;
    private String familyName;
    private Gender gender;
    private LocalDate birthDate;

    public UserRequestDTO(String firstName, String familyName, Gender gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
