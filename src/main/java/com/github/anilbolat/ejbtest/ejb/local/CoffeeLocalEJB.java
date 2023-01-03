package com.github.anilbolat.ejbtest.ejb.local;

import com.github.anilbolat.ejbtest.data.Coffee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CoffeeLocalEJB {
    List<Coffee> findAll();

    void create(Coffee coffee);

    void update(Long id, Coffee coffee);

    void remote(Long id);
}
