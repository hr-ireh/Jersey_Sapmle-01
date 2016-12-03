package ir.hri.core.repositories.impl;

import ir.hri.core.entities.City;
import ir.hri.core.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext(unitName = "entityManagerFactory")
    EntityManager entityManager;

    @Override
    public City findById(int id) throws Exception {
        Query query = entityManager.createQuery("select t from City t where t.id = :id");
        query.setParameter("id", Integer.valueOf(id));
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
        query.setParameter("stateId", Integer.valueOf(stateId));
        List<City> cityList = query.getResultList();
        return cityList;
    }
}
