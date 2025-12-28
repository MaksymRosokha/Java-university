package com.rosokha.contactTypes;

import com.rosokha.contactMethods.ContactMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Person extends Contact {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String tag;

    public Person(String displayName, String firstName, String lastName, LocalDate birthDate, String tag) {
        super(displayName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.tag = tag;
    }

    public Person(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
        super.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName;
    }

}
