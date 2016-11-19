package ir.hri.rest.controller;

import ir.hri.core.entities.City;
import ir.hri.core.services.CityService;
import ir.hri.core.services.impl.CityServiceImpl;
import ir.hri.rest.utils.ApiV1Urls;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path(ApiV1Urls.BaseInfo.BASE_INFO)
public class BaseInfo {

    @GET
    @Path(ApiV1Urls.BaseInfo.CITIES)
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> cities() {
        CityService cityService = new CityServiceImpl();
        List<City> cityList = null;

        try {
            cityList = cityService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @GET
    @Path(ApiV1Urls.BaseInfo.STATES)
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> states() {

        return new ArrayList<>();
    }
}
