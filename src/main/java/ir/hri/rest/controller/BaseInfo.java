package ir.hri.rest.controller;

import ir.hri.core.entities.City;
import ir.hri.core.entities.State;
import ir.hri.core.services.CityService;
import ir.hri.core.services.StateService;
import ir.hri.core.services.impl.CityServiceImpl;
import ir.hri.core.services.impl.StateServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static ir.hri.rest.utils.ApiV1Urls.BaseInfo.*;

@Path(BASE_INFO)
public class BaseInfo {

    @GET
    @Path(PATH_CITIES)
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
    @Path(PATH_CITY_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public City city(@PathParam(PARAM_ID) int id) {
        CityService cityService = new CityServiceImpl();
        City city = null;
        try {
            city = cityService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @GET
    @Path(PATH_CITIES_STATE_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> cities(@PathParam(PARAM_STATE_ID) int stateId) {
        CityService cityService = new CityServiceImpl();
        List<City> cityList = null;
        try {
            cityList = cityService.findByStateId(stateId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @GET
    @Path(PATH_STATES)
    @Produces(MediaType.APPLICATION_JSON)
    public List<State> states() {
        StateService stateService = new StateServiceImpl();
        List<State> stateList = null;
        try {
            stateList = stateService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateList;
    }

    @GET
    @Path(PATH_STATE_ID)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public State state(@PathParam(PARAM_ID) int id) {
        StateService stateService = new StateServiceImpl();
        State state = null;
        try {
            state = stateService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
}