package com.vicego.recordtracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String firstName, lastName, town, email, lga;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDateTime dateOfReg;

    public Person(String firstName, String lastName, String town, String email, String lga, Gender gender, LocalDate dateOfBirth, LocalDateTime dateOfReg) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
