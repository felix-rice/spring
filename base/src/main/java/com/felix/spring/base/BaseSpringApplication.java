package com.felix.spring.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.felix.spring.base.aop.Add;
import com.felix.spring.base.config.AppConfig;

public class BaseSpringApplication {
	@SuppressWarnings("checkstyle:FileTabCharacter")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			Add add = (Add) context.getBean("add");
			add.add(2, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
