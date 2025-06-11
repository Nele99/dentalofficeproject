package me.dentaloffice.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Patient;
import me.dentaloffice.repository.PatientRepository;
import me.dentaloffice.dto.PatientFileRequest;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;



@Path("/patient")
public class PatientResource {

    private static final String UPLOAD_DIR = "uploads/patients/";

    @Inject
    private PatientRepository patientRepository;

    @POST
    @Path("/addPatient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createPatient(Patient patient) {
        Patient p = patientRepository.createPatient(patient);
        return Response.status(Response.Status.CREATED).entity(p).build();
    }

    @GET
    @Path("/getAllPatients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        List<Patient> patients = patientRepository.getAllPatients();
        return Response.ok(patients).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientWithFile(@PathParam("id") int patientId) {
        try {
            Patient patient = patientRepository.findById(patientId);
            if (patient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Patient not found")
                        .build();
            }

            if (patient.getFilePath() != null && !patient.getFilePath().isEmpty()) {
                Path filePath = Paths.get(patient.getFilePath());
                if (Files.exists(filePath)) {
                    byte[] fileData = Files.readAllBytes(filePath);
                    patient.setFileData(fileData);
                }
            }

            return Response.ok(patient).build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error reading file: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/{id}/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadFile(@PathParam("id") int patientId, PatientFileRequest request) {
        try {

            Patient patient = patientRepository.findById(patientId);
            if (patient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Patient not found")
                        .build();
            }


            Path uploadDir = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }


            FileUpload file = request.getFile();
            String originalFileName = file.fileName();
            String fileExtension = originalFileName.contains(".") ? originalFileName.substring(originalFileName.lastIndexOf(".")) : "";
            String fileName = "patient_" + patientId + "_" + System.currentTimeMillis() + fileExtension;


            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(file.uploadedFile(), filePath, StandardCopyOption.REPLACE_EXISTING);


            patient.setFilePath(filePath.toString());
            patientRepository.updatePatient(patient);

            return Response.ok("File uploaded successfully: " + fileName).build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error uploading file: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}/file")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("id") int patientId) {
        try {
            Patient patient = patientRepository.findById(patientId);
            if (patient == null || patient.getFilePath() == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("File not found")
                        .build();
            }

            Path filePath = Paths.get(patient.getFilePath());
            if (!Files.exists(filePath)) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("File not found on filesystem")
                        .build();
            }

            byte[] fileData = Files.readAllBytes(filePath);
            String fileName = filePath.getFileName().toString();

            return Response.ok(fileData)
                    .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                    .build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error downloading file: " + e.getMessage())
                    .build();
        }
    }
}