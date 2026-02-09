package model;

import java.time.LocalDate;

public class Patient {

    private int id;
    private String name;
    private String document; // CNS or CPF
    private LocalDate birthDate;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + document + " | " + birthDate;
    }
}
