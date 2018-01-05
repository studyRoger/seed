package org.roger.service;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GreetingServiceImplTest {

    @Test
    public void hello() throws Exception {
        GreetingService greetingService = new GreetingServiceImpl();
        assertThat(greetingService.hello("Roger"), is("Hello Roger!"));
    }

    @Test
    public void bye() throws Exception {
        //TODO:
    }

}