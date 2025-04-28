package me.dentaloffice.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Patient;

@Dependent
public class PatientService {

    @Inject
    private EntityManager em;

    @Transactional
    public Patient createPatient(Patient p){
        return em.merge(p);
    }



}
