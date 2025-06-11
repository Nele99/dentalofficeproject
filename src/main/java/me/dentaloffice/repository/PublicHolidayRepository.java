package me.dentaloffice.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import me.dentaloffice.model.PublicHoliday;

@ApplicationScoped
public class PublicHolidayRepository implements PanacheRepository<PublicHoliday> {

    public boolean existsByYear(int year) {
        return count("from PublicHoliday where year(date) = ?1", year) > 0;
    }
}
