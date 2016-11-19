package ir.hri.core.services.impl;

import ir.hri.core.entities.City;
import ir.hri.core.repositories.CityRepository;
import ir.hri.core.repositories.impl.CityRepositoryImpl;
import ir.hri.core.services.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {
    CityRepository cityRepository = new CityRepositoryImpl();

    @Override
    public City findById(int id) throws Exception {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> findAll() throws Exception {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findByStateId(int stateId) throws Exception {
        return cityRepository.findByStateId(stateId);
    }
}