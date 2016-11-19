package ir.hri.core.repositories.impl;

import ir.hri.core.entities.City;
import ir.hri.core.repositories.CityRepository;
import ir.hri.core.util.JPAUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {
    EntityManager entityManager =
            JPAUtility.getEntityManager();

    @Override
    public City findById(int id) throws Exception {
        Query query = entityManager.createQuery("select t from City t where t.id = :id");
        query.setParameter("id", new Integer(id));
        City city = (City) query.getSingleResult();
        return city;
    }

    @Override
    public List<City> findAll() throws Exception {
        Query query = entityManager.createQuery("select t from City t");
        List<City> cityList = query.getResultList();
        return cityList;
    }

    @Override
    public List<City> findByStateId(int stateId) throws Exception {
        Query query = entityManager.createQuery("select t from City t where t.stateId = :stateId");
        query.setParameter("stateId", new Integer(stateId));
        List<City> cityList = query.getResultList();
        return cityList;
    }
}
