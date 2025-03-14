package me.dentaloffice.model;

import java.math.BigDecimal;
import java.security.Timestamp;

public class CheckupHistory {
    private int id;
    private Checkup checkup;
    private Patient patient;
    private Dentist dentist;
    private CheckupType type;
    private String description;
    private Timestamp createdAt;
    private BigDecimal totalPrice;

    public CheckupHistory() {}

    public CheckupHistory(int id, Checkup checkup, Patient patient, Dentist dentist, CheckupType type, String description, Timestamp createdAt, BigDecimal totalPrice) {
        this.id = id;
        this.checkup = checkup;
        this.patient = patient;
        this.dentist = dentist;
        this.type = type;
        this.description = description;
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
    }
}
