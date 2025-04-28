package me.dentaloffice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "checkup_type")
public class CheckupType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public CheckupType() {}

    public CheckupType(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
