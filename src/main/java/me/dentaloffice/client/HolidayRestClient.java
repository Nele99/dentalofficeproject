package me.dentaloffice.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;
import java.util.Map;

@RegisterRestClient(baseUri = "https://date.nager.at/api/v3")
public interface HolidayRestClient {

    @GET
    @Path("/AvailableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    List<Map<String, String>> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Map<String, Object>> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}