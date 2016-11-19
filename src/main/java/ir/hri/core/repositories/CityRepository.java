package ir.hri.core.repositories;

import ir.hri.core.entities.City;

import java.util.List;

public interface CityRepository {
    City findById(int id) throws Exception;

    List<City> findAll() throws Exception;

    List<City> findByStateId(int stateId) throws Exception;
}
