package com.felix.spring.base.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-14
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 5329153825511147319L;
    private Long id;
    private Long userId;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
