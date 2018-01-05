package org.roger.service;


import org.roger.common.GreetingUtil;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String hello(String name) {
        return GreetingUtil.hello(name);
    }

    @Override
    public String bye(String name) {
        throw new UnsupportedOperationException();
    }
}
