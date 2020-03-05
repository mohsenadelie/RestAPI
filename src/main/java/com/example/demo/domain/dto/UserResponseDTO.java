package com.example.demo.domain.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.example.demo.domain.Gender;

public class UserResponseDTO {
    private String fullName;
    private Gender gender;
    private LocalDate birthDate;

    public UserResponseDTO(String fullName, Gender gender, LocalDate birthDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponseDTO)) return false;
        UserResponseDTO that = (UserResponseDTO) o;
        return getFullName().equals(that.getFullName()) &&
                getGender() == that.getGender() &&
                getBirthDate().equals(that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getGender(), getBirthDate());
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
