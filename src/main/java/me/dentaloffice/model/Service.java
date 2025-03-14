package me.dentaloffice.model;

import java.math.BigDecimal;
import java.util.List;

public class Service {
    private int id;
    private String name;
    private BigDecimal price;
    private List<Checkup> checkups;

    public Service() {}

    public Service(int id, String name, BigDecimal price, List<Checkup> checkups) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.checkups = checkups;
    }
}
