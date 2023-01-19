package com.felix.spring.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-11
 */
public class UserServiceProxy implements InvocationHandler {
    private static final Logger log = Logger.getLogger(UserServiceProxy.class.getName());
    private final Object obj;
    public UserServiceProxy(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法执行之前的增强
        log.info("before...");
        // 方法
        Object ret = method.invoke(obj, args);
        log.info(ret.toString());
        // 方法执行之后的增强
        log.info("after...");
        return ret;
    }
}
