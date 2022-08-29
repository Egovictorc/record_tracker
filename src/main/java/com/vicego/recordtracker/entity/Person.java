package com.vicego.recordtracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String firstName, lastName, password, town, email, lga;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDateTime dateOfReg;

    public Person(String firstName, String lastName, String password, String town, String email, String lga, Gender gender, LocalDate dateOfBirth, LocalDateTime dateOfReg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.town = town;
        this.email = email;
        this.lga = lga;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfReg = dateOfReg;
    }

    public static enum Gender {
        MALE, FEMALE
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(LocalDateTime dateOfReg) {
        this.dateOfReg = dateOfReg;
    }
}
