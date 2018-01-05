package org.roger.service;

public class Main {

    public static void main(String[] args) {
        GreetingService greetingService = new GreetingServiceImpl();
        System.out.println(greetingService.hello("Roger"));
    }
}
