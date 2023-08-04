package com.example;

import org.apache.logging.log4j.ThreadContext;
import org.jboss.logging.MDC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MDCLog4j2ResourceTest {

    @BeforeAll
    public static void setup() {
        System.setProperty("org.jboss.logging.provider", "log4j2");
    }

    @Test
    void testMdc() throws ClassNotFoundException {
        MDC.put("test.key", "value");
        Assertions.assertEquals("value", MDC.get("test.key"));
        Assertions.assertEquals("value", ThreadContext.get("test.key"));
        final ClassLoader cl = MDCLog4j2ResourceTest.class.getClassLoader();

        Class.forName("org.apache.logging.log4j.Logger", true, cl);
        Class.forName("org.apache.logging.log4j.LogManager", true, cl);
        Class.forName("org.apache.logging.log4j.spi.AbstractLogger", true, cl);
    }

}