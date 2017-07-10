package com.emc.roger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cher5 on 2017/3/10.
 */
public class HelloJavaTest {
    @Test
    public void sayHello() throws Exception {
        assertEquals("Roger! Hello from Java", HelloJava.sayHello("Roger"));
    }

}