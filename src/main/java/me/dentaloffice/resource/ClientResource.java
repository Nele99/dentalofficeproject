package me.dentaloffice.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.client.HolidayRestClient;
import me.dentaloffice.model.PublicHoliday;
import me.dentaloffice.model.HolidayType;
import me.dentaloffice.repository.PublicHolidayRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Path("/holidays")
public class ClientResource {

    @Inject
    @RestClient
    HolidayRestClient restClient;

    @Inject
    PublicHolidayRepository holidayRepository;

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCountries() {
        return Response.ok(restClient.getAvailableCountries()).build();
    }

    @GET
    @Path("/next/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        List<Map<String, Object>> holidays = restClient.getNextPublicHolidays(countryCode);

        if (holidays.isEmpty()) {
            return Response.ok(holidays).build();
        }

        int year = LocalDate.parse((String) holidays.get(0).get("date")).getYear();
        if (holidayRepository.existsByYear(year)) {
            return Response.ok(holidays).build();
        }

        for (Map<String, Object> holiday : holidays) {
            PublicHoliday publicHoliday = new PublicHoliday();
            publicHoliday.setDate(LocalDate.parse((String) holiday.get("date")));
            publicHoliday.setName((String) holiday.get("name"));
            publicHoliday.setCountryCode((String) holiday.get("countryCode"));

            List<String> types = (List<String>) holiday.get("types");
            if (types != null) {
                for (String type : types) {
                    HolidayType holidayType = new HolidayType();
                    holidayType.setName(type);
                    publicHoliday.getTypes().add(holidayType);
                }
            }
            holidayRepository.persist(publicHoliday);
        }
        return Response.ok(holidays).build();
    }
}