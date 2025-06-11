package me.dentaloffice.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Patient;
import me.dentaloffice.repository.PatientRepository;

import java.util.List;

@Path("/patient")
public class PatientResource {

@Inject
    private PatientRepository patientRepository;

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
@Path("addPatient")
    public Response createPatient( Patient patient){
    Patient p = patientRepository.createPatient(patient);
    return Response.status(Response.Status.CREATED).entity(p).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPatients")
    public Response getAllPatients() {
            List<Patient> patients = patientRepository.getAllPatients();
            return Response.ok(patients).build();
        }




}
