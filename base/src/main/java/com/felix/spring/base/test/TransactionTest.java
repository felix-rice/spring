package com.felix.spring.base.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.felix.spring.base.config.AppConfig;
import com.felix.spring.base.entity.Account;
import com.felix.spring.base.service.AccountService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-14
 */
public class TransactionTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/bean.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        Account userFrom = accountService.getAccountById(1L);
        Account userTo = accountService.getAccountById(2L);
        BigDecimal transferMoney = new BigDecimal("100");
        accountService.transfer(userFrom, userTo, transferMoney);
    }
}
