package com.felix.spring.base.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-13
 */
@Component
public class User implements Serializable {
    private static final long serialVersionUID = 5485577572275591071L;
    private Long id;
    private String name;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", status='" + status + '\''
                + '}';
    }
}
