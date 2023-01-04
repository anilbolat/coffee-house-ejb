package com.github.anilbolat.ejbtest.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long coffeeId;

    public Orders() {
    }

    public Orders(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", coffeeId=" + coffeeId +
                '}';
    }
}
