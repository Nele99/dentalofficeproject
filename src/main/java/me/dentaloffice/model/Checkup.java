package me.dentaloffice.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Checkup {
    private int id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private CheckupStatus status;
    private CheckupType type;
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

