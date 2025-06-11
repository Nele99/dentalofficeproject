package me.dentaloffice.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Checkup;
import me.dentaloffice.repository.CheckupRepository;

import java.util.List;

@Path("/checkup")
public class CheckupResource {

    @Inject
    private CheckupRepository checkupRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("addCheckup")
    public Response createCheckup(Checkup checkup) {
        Checkup c = checkupRepository.createCheckup(checkup);
        return Response.status(Response.Status.CREATED).entity(c).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllCheckups")
    public Response getAllCheckups() {
        List<Checkup> checkups = checkupRepository.getAllCheckups();
        return Response.ok(checkups).build();
    }
}