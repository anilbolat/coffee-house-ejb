package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CoffeeOrderRemoteEJB {

    List<Coffee> checkCoffeeList();

    String checkCoffeePrice(Coffee coffee);

    boolean orderCoffee(Long coffeeId);

}
