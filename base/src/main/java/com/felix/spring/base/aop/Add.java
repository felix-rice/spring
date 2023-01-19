package com.felix.spring.base.aop;

import org.springframework.stereotype.Component;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-11
 */
@Component
public class Add {
    public int add(int a, int b) {
        return a + b;
    }
}
