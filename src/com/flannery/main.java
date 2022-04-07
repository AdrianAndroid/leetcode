package com.flannery;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList<Interceptor> list = new ArrayList<>();
        list.add(new Intercept_1());
        list.add(new Intercept_2());
        list.add(new Intercept_3());

        Request request = new Request();

        RealInterceptorChain chian = new RealInterceptorChain(
                list,
                0,
                request
        );

        Response proceed = chian.proceed(request);

    }

}


class Intercept_1 implements Interceptor {

    @Override
    public Response intercept(Chain chain) {
        System.out.println("Intercept_1 intercept");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request;
        Response response = realChain.proceed(request);
        return response;
    }
}

class Intercept_2 implements Interceptor {

    @Override
    public Response intercept(Chain chain) {
        System.out.println("Intercept_2 intercept");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request;
        Response response = realChain.proceed(request);
        return response;
    }
}

class Intercept_3 implements Interceptor {

    @Override
    public Response intercept(Chain chain) {
        System.out.println("Intercept_3 intercept");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request;
        Response response = realChain.proceed(request);
        return response;
    }
}


class RealInterceptorChain implements Interceptor.Chain {

    private int calss = 0;
    private ArrayList<Interceptor> interceptors;
    private int index;
     Request request;

    public RealInterceptorChain(ArrayList<Interceptor> interceptors, int index, Request request) {
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
    }

    @Override
    public Response proceed(Request request) {

        if(index == interceptors.size()) {
            return new Response();
        }

        // call the next
        RealInterceptorChain next = new RealInterceptorChain(
                interceptors, index + 1, request
        );
        Interceptor interceptor = interceptors.get(index);

        Response response = interceptor.intercept(next);
        return response;
    }
}


interface Interceptor {

    Response intercept(Chain chain);

    interface Chain {
        Response proceed(Request request);
    }
}


class Request {

}

class Response {

}
