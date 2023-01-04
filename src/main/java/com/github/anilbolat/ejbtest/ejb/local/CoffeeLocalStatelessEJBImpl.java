package com.github.anilbolat.ejbtest.ejb.local;

import com.github.anilbolat.ejbtest.data.Coffee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CoffeeLocalStatelessEJBImpl implements CoffeeLocalEJB {

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
        entity.setDescription(coffee.getDescription());
        entity.setPrice(coffee.getPrice());
        entityManager.merge(entity);
    }

    @Override
    public void remote(Long id) {
        Coffee entity = entityManager.find(Coffee.class, id);
        entityManager.remove(entity);
    }
}
