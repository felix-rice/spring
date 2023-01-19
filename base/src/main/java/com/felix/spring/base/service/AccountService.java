package com.felix.spring.base.service;

import java.math.BigDecimal;

import com.felix.spring.base.entity.Account;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-14
 */
public interface AccountService {
    void create(Account account);
    void transfer(Account userFrom, Account userTo, BigDecimal money);
    Account getAccountById(Long id);
}
