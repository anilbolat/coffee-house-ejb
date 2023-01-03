package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CoffeeRemoteStatelessEJBImpl implements CoffeeRemoteEJB {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Coffee> findAll() {
        Query query = entityManager.createQuery("select c from Coffee c");
        return query.getResultList();
    }

    @Override
    public void create(Coffee coffee) {
        entityManager.persist(coffee);
    }

    @Override
    public void update(Long id, Coffee coffee) {
        Coffee entity = entityManager.find(Coffee.class, id);
        if (entity != null) {
            entity.setDescription(coffee.getDescription());
            entity.setPrice(coffee.getPrice());
            entityManager.merge(entity);
        }
    }

    @Override
    public void remove(Long id) {
        Coffee entity = entityManager.find(Coffee.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
