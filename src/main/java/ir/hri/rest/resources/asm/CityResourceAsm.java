package ir.hri.rest.resources.asm;

import ir.hri.core.entities.City;
import ir.hri.rest.resources.CityResource;

public class CityResourceAsm {
    public static CityResource toResource(City city) {
        CityResource cityResource = new CityResource();
        cityResource.setId(city.getId());
        cityResource.setName(city.getName());
        cityResource.setStateId(city.getStateId());

        return cityResource;
    }
}