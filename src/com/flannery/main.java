package com.flannery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class main {
//https://www.bilibili.com/video/BV1cz41187Dk?spm_id_from=333.337.search-card.all.click


    // 动态代理的作用
    // 1. 可以拦截方法，动态处理
    // 2。 解耦合(返回相同类型，也就是有一个具体的实现了类:比如Retrofit中的Call)

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        ServiceImpl serviceImpl = new ServiceImpl();
        Service service = (Service) Proxy.newProxyInstance(
                serviceImpl.getClass().getClassLoader(),
                new Class<?>[]{Service.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName() == "isFine") {
                            return true;
                        }
                        return method.invoke(serviceImpl, args);
                    }
                }
        );
        if (service != null) {
            System.out.println(""+service.isFine());
            service.hello();
        }
    }

}

interface Service {
    boolean isFine();

    void hello();
}

class ServiceImpl implements Service {

    @Override
    public boolean isFine() {
        return false;
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
