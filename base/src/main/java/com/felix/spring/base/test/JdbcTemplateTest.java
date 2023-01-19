package com.felix.spring.base.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.felix.spring.base.dao.BookDao;
import com.felix.spring.base.entity.Book;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-13
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        // xml配置
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/bean.xml");
        // 注解配置
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        Book book = new Book();
        book.setName("兄弟");
        book.setPrice(new BigDecimal("69.99"));
        bookDao.insert(book);
        // bookDao.delete(1L);
    }
}
