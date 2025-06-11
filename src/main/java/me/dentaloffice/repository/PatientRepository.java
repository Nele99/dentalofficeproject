package me.dentaloffice.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Checkup;
import me.dentaloffice.model.Patient;

import java.util.List;

@Dependent
public class PatientRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Patient createPatient(Patient p) {
        if (p.getCheckups() != null) {
            for (Checkup checkup : p.getCheckups()) {
                checkup.setPatient(p);
            }
        }
        em.persist(p);
        return p;
    }

    @Transactional
    public List<Patient> getAllPatients() {
        return em.createQuery("SELECT p FROM Patient p LEFT JOIN FETCH p.checkups", Patient.class)
                .getResultList();
    }

    // Dodaj ove metode za file operacije
    public Patient findById(int id) {
        return em.find(Patient.class, id);
    }

    @Transactional
    public Patient updatePatient(Patient patient) {
        return em.merge(patient);
    }
}