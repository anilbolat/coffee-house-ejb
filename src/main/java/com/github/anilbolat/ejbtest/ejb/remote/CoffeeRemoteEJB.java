package com.github.anilbolat.ejbtest.ejb.remote;

import com.github.anilbolat.ejbtest.data.Coffee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CoffeeRemoteEJB {
    List<Coffee> findAll();

    void create(Coffee coffee);

    void update(Long id, Coffee coffee);

    void remove(Long id);
}
