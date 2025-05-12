package me.dentaloffice.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Patient;
import me.dentaloffice.model.Telephone;

import java.util.List;


@Dependent
public class PatientRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Patient createPatient(Patient p) {
        if (p.getTelephones() != null) {
            for (Telephone telephone : p.getTelephones()) {
                telephone.setPatient(p);
            }
        }
        em.persist(p);
        return p;
    }

    @Transactional
    public List<Patient> getAllPatients() {
        List<Patient> patients = em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();

        for (Patient patient : patients) {
            List<Telephone> telephones = em.createQuery("SELECT t FROM Telephone t WHERE t.patient.id = :id", Telephone.class)
                    .setParameter("id", patient.getId())
                    .getResultList();
            patient.setTelephones(telephones);

        }

        return patients;
    }


    }

