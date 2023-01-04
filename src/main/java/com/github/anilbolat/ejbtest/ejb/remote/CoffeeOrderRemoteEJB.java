package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;
import com.github.anilbolat.ejbtest.data.Orders;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CoffeeOrderRemoteEJB {

    List<Coffee> checkCoffeeList();

    String checkCoffeePrice(Long id);

    boolean orderCoffee(Long coffeeId);

    List<Orders> getOrders();

}
