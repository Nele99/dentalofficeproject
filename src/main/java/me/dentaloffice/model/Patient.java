package me.dentaloffice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    private PatientStatus status_id ;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Checkup> checkups;

    public Patient() {}

    public Patient(int id, String jmbg, String name, String surname, LocalDate dateOfBirth, String phone, String email, String address, PatientStatus status_id) {
        this.id = id;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status_id = status_id;

    }

    public Patient(int id, String jmbg, String name, String surname, LocalDate dateOfBirth, String phone, String email, String address, PatientStatus status_id, List<Checkup> checkups) {
        this.id = id;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status_id = status_id;
        this.checkups = checkups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PatientStatus getStatus_id() {
        return status_id;
    }

    public void setStatus_id(PatientStatus status_id) {
        this.status_id = status_id;
    }

    public List<Checkup> getCheckups() {
        return checkups;
    }

    public void setCheckups(List<Checkup> checkups) {
        this.checkups = checkups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(jmbg, patient.jmbg)
                && Objects.equals(name, patient.name) &&
                Objects.equals(surname, patient.surname) &&
                Objects.equals(dateOfBirth, patient.dateOfBirth) &&
                Objects.equals(phone, patient.phone) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(status_id, patient.status_id) &&
                Objects.equals(checkups, patient.checkups);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, jmbg, name, surname, dateOfBirth, phone, email, address, status_id,checkups);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id + ", jmbg='" + jmbg + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth + ", phone='" + phone + '\'' + ", email='" + email + '\'' +
                ", address='" + address + '\'' + ", status=" + status_id + ", checkups=" + checkups + '}';
    }
}
