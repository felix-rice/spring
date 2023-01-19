package com.felix.spring.base.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.felix.spring.base.dao.AccountDao;
import com.felix.spring.base.entity.Account;
import com.felix.spring.base.service.AccountService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-14
 */
@Service(value = "accountService")
@Transactional(readOnly = false, timeout = -1, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void create(Account account) {
        accountDao.insert(account);
    }

    @Override
    public void transfer(Account userFrom, Account userTo, BigDecimal money) {
        userFrom.setBalance(userFrom.getBalance().subtract(money));
        accountDao.update(userFrom);
        // 人为构造异常
        // int a = 10 / 0;
        userTo.setBalance(userTo.getBalance().add(money));
        accountDao.update(userTo);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountDao.select(id);
    }
}
