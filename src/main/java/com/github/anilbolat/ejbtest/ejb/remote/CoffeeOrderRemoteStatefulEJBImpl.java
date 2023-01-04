package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;
import com.github.anilbolat.ejbtest.data.Orders;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CoffeeOrderRemoteStatefulEJBImpl implements CoffeeOrderRemoteEJB {

    private final List<Orders> orders = new ArrayList<>();
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Coffee> checkCoffeeList() {
        Query query = entityManager.createQuery("select c from Coffee c");
        return query.getResultList();
    }

    @Override
    public String checkCoffeePrice(Long id) {
        Coffee entity = entityManager.find(Coffee.class, id);
        if (entity != null) {
            return entity.getPrice();
        } else {
            return "Not Found!";
        }
    }

    @Override
    public boolean orderCoffee(Long coffeeId) {
        Coffee entity = entityManager.find(Coffee.class, coffeeId);
        if (entity != null) {
            Orders order = new Orders(entity.getId());
            entityManager.persist(order);
            this.orders.add(order);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Orders> getOrders() {
        return orders;
    }
}
