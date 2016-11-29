package ir.hri.rest.controller;

import ir.hri.core.entities.City;
import ir.hri.core.entities.State;
import ir.hri.core.services.CityService;
import ir.hri.core.services.StateService;
import ir.hri.rest.resources.CitiesResource;
import ir.hri.rest.resources.StatesResource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static ir.hri.rest.utils.ApiV1Urls.BaseInfoPath.*;

@Controller
@Path(BASE_INFO)
public class BaseInfo {
    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    private static final Logger logger = Logger.getLogger(BaseInfo.class);

    @GET
    @Path(PATH_CITIES)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cities() {
        logger.info("Call cities");
        List<City> cityList = null;
        try {
            cityList = cityService.findAll();
        } catch (Exception e) {
            logger.error("Error cities");
            e.printStackTrace();
            return Response.serverError().build();
        }
        return Response.ok().entity(new CitiesResource(cityList)).build();
    }

    @GET
    @Path(PATH_CITY_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response city(@PathParam(PARAM_ID) int id) {
        logger.info("Call city");
        City city = null;
        try {
            city = cityService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
        return Response.ok().entity(city).build();
    }

    @GET
    @Path(PATH_CITIES_STATE_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cities(@PathParam(PARAM_STATE_ID) int stateId) {
        logger.info("Call cities");
        List<City> cityList = null;
        try {
            cityList = cityService.findByStateId(stateId);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
        return Response.ok().entity(new CitiesResource(cityList)).build();
    }

    @GET
    @Path(PATH_STATES)
    @Produces(MediaType.APPLICATION_JSON)
    public Response states() {
        logger.info("Call states");
        List<State> stateList = null;
        try {
            stateList = stateService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok().entity(new StatesResource(stateList)).build();
    }

    @GET
    @Path(PATH_STATE_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response state(@PathParam(PARAM_ID) int id) {
        logger.info("Call state");
        State state = null;
        try {
            state = stateService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok().entity(state).build();
    }
}