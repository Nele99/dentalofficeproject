package me.dentaloffice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jmbg;
    private String name;
    private String surname;
    private String specialization;
    private String phone;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "dentists_patients",
            joinColumns = @JoinColumn(name = "dentist_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients;
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
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