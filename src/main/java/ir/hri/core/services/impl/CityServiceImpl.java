package ir.hri.core.services.impl;

import ir.hri.core.entities.City;
import ir.hri.core.repositories.CityRepository;
import ir.hri.core.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

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