package com.vicego.recordtracker.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Person {
    private String firstName, lastName, town, email, lga;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDateTime dateOfReg;

    public static enum Gender {
        MALE, FEMALE
    }
}
