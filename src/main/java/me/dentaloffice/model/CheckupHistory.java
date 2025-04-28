package me.dentaloffice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "checkup_history")
public class CheckupHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Checkup checkup;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Dentist dentist;
    @ManyToOne
    private CheckupType type;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public CheckupHistory() {}

    public CheckupHistory(int id, Checkup checkup, Patient patient, Dentist dentist, CheckupType type, String description, LocalDateTime createdAt, BigDecimal totalPrice) {
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
