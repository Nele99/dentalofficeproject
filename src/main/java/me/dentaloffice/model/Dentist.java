package me.dentaloffice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(
            name = "dentists_patients",
            joinColumns = @JoinColumn(name = "dentist_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;
    @OneToMany(mappedBy = "dentist", cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Checkup> checkups;

}