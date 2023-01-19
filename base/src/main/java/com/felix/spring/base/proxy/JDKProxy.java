package com.felix.spring.base.proxy;

import java.lang.reflect.Proxy;

import com.felix.spring.base.service.AddService;
import com.felix.spring.base.service.impl.AddServiceImpl;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-11
 */
public class JDKProxy {
    public static void main(String[] args) {
        Class<?>[] interfaces = {AddService.class};
        AddServiceImpl addServiceImpl = new AddServiceImpl();
        AddService addService = (AddService) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                interfaces, new UserServiceProxy(addServiceImpl));
        addService.add(1, 2);
    }
}
