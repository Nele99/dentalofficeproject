package me.dentaloffice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal price;
    @ManyToMany(mappedBy = "services")

    private List<Checkup> checkups;

    public Service() {}

    public Service(int id, String name, BigDecimal price, List<Checkup> checkups) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.checkups = checkups;
    }
}
