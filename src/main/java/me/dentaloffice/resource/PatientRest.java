package me.dentaloffice.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Patient;
import me.dentaloffice.service.PatientService;

@Path("/patient")
public class PatientRest {

@Inject
    private PatientService patientService;

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/addPatient")
    public Response createPatient(Patient patient){
       Patient p = patientService.createPatient(patient);
       return Response.ok().entity(p).build();
    }
}
