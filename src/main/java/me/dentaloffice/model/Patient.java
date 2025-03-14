package me.dentaloffice.model;

import java.time.LocalDate;
import java.util.List;

public class Patient {
    private int id;
    private String jmbg;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private PatientStatus status;
    private List<Checkup> checkups;

    public Patient() {}

    public Patient(int id, String jmbg, String name, String surname, LocalDate dateOfBirth, String phone, String email, String address, PatientStatus status, List<Checkup> checkups) {
        this.id = id;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.checkups = checkups;
    }
}
