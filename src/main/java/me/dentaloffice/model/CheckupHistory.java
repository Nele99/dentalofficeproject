package me.dentaloffice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
