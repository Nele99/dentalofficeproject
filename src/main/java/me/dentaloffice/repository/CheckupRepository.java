package me.dentaloffice.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Checkup;
import me.dentaloffice.model.Service;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class CheckupRepository {

    @Inject
    private EntityManager em;


    @Transactional
    public Checkup createCheckup(Checkup checkup) {
        if (checkup.getServices() != null) {
            for (Service service : checkup.getServices()) {
                if (service.getCheckups() == null) {
                    service.setCheckups(new ArrayList<>());
                }
                if (!service.getCheckups().contains(checkup)) {
                    service.getCheckups().add(checkup);
                }
            }
        }
        em.persist(checkup);
        return checkup;
    }


    @Transactional
    public List<Checkup> getAllCheckups() {
        return em.createQuery("SELECT c FROM Checkup c LEFT JOIN FETCH c.services", Checkup.class)
                .getResultList();
    }
}