package com.felix.spring.base.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-13
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 6678443407810677148L;
    private Long id;
    private String name;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
