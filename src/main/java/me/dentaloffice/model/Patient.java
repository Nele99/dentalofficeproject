package me.dentaloffice.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jmbg;
    private String name;
    private String surname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_id")
    private PatientStatus status_id;

    @Column(name = "file_path")
    private String filePath;

    @Transient
    private byte[] fileData;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Checkup> checkups;
}