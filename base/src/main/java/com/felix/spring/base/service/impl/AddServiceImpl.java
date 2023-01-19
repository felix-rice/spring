package com.felix.spring.base.service.impl;

import com.felix.spring.base.service.AddService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-11
 */
public class AddServiceImpl implements AddService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
