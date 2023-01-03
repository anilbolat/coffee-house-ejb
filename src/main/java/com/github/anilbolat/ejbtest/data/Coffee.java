package com.github.anilbolat.ejbtest.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Coffee implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String description;
    @Column
    private String price;

    public Coffee() {
    }

    public Coffee(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
