package me.dentaloffice.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "checkups")
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Dentist dentist;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_id")
    private CheckupStatus status;
    @ManyToOne
    private CheckupType type;

    @ManyToMany
    @JoinTable(
            name = "checkups_services",
            joinColumns = @JoinColumn(name = "checkup_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

    public Checkup() {}

    public Checkup(int id, Patient patient, Dentist dentist, LocalDate date, LocalTime time, int duration, CheckupStatus status, CheckupType type, List<Service> services) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.status = status;
        this.type = type;
        this.services = services;
    }
}

