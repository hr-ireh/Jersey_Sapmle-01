package ir.hri.core.repositories.impl;

import ir.hri.core.entities.City;
import ir.hri.core.repositories.CityRepository;
import ir.hri.core.util.JPAUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {
    EntityManager entityManager;

    {
        try {
            System.out.println("---ok.");
            entityManager =
                    JPAUtility.getEntityManager();
            System.out.println("---ok.2");
        } catch (Exception e) {
            System.out.println("---er: " + e.getMessage());
        }

    }

    @Override
    public City findById(int id) throws Exception {
        Query query = entityManager.createQuery("select t from City t where t.id = :id");
        query.setParameter("id", new Integer(id));
        City city = (City) query.getSingleResult();
        return city;
    }

    @Override
    public List<City> findAll() throws Exception {
        System.out.println("----------CityRepositoryImpl.findAll");
        Query query = entityManager.createQuery("select t from City t");
        List<City> cityList = query.getResultList();

        System.out.println("----------CityRepositoryImpl.findAll.ok");
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