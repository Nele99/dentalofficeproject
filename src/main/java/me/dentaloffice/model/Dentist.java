package me.dentaloffice.model;

import java.util.List;

public class Dentist {
    private int id;
    private String jmbg;
    private String name;
    private String surname;
    private String specialization;
    private String phone;
    private String email;
    private List<Patient> patients;
    private List<Checkup> checkups;

    public Dentist() {}

    public Dentist(int id, String jmbg, String name, String surname, String specialization, String phone, String email, List<Patient> patients, List<Checkup> checkups) {
        this.id = id;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.patients = patients;
        this.checkups = checkups;
    }
}