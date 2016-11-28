package ir.hri.rest.resources;

import ir.hri.core.entities.City;

import java.util.ArrayList;
import java.util.List;

public class CitiesResource {
    List<City> cities = new ArrayList<>();

    public CitiesResource() {
    }

    public CitiesResource(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
