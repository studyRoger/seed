package org.roger.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cher5 on 2017/3/10.
 */
public class HelloJava {
    final static private Logger logger = LoggerFactory.getLogger(HelloJava.class);

    public static void main(String[] args) {

        sayHello("Java");


    }

    static String sayHello(String name) {
        String retVal = name + "! Hello from Java";
        logger.debug("sayHello - " + retVal);
        logger.warn("warn: sayHello - " + retVal);
        return retVal;
    }
}
