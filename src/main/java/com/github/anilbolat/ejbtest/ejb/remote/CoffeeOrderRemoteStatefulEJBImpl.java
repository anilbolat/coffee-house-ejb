package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;
import com.github.anilbolat.ejbtest.data.Order;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CoffeeOrderRemoteStatefulEJBImpl implements CoffeeOrderRemoteEJB {

    private final List<Order> orders = new ArrayList<>();
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Coffee> checkCoffeeList() {
        Query query = entityManager.createQuery("select c from Coffee ");
        return query.getResultList();
    }

    @Override
    public String checkCoffeePrice(Coffee coffee) {
        return coffee.getPrice();
    }

    @Override
    public boolean orderCoffee(Long coffeeId) {
        Order order = new Order(coffeeId);
        System.out.println(order.toString());
        return orders.add(order);
    }
}
