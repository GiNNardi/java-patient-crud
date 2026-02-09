package model;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

    private int id;
    private String name;
    private String document;
    private LocalDate birthDate;
    private String phone;

    public Patient(int id, String name, String document, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Name: " + name
                + " | Age: " + getAge()
                + " | Phone: " + (phone == null ? "Not informed" : phone);
    }
}
