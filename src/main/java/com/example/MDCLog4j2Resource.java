package com.example;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.jboss.logging.MDC;

@Path("/hello")
@Log4j2
public class MDCLog4j2Resource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {

        MDC.put("MDCTest", "MDCTest");
        System.out.println("MDC value:" + MDC.get("MDCTest"));
        System.out.println("ThreadContext MDCTest value:" + ThreadContext.get("MDCTest"));
        System.out.println("log4j Logger class: " + getClass().getClassLoader()
                                                              .getResources("org/apache/log4j/Logger.class"));
        System.out.println("log4j LogManager class: " + getClass().getClassLoader()
                                                                  .getResources("org.apache.logging.log4j.LogManager"));
        System.out.println("log42 AbstractLogger Logger: " + getClass().getClassLoader()
                                                                       .getResources(
                                                                           "org.apache.logging.log4j.spi.AbstractLogger"));

        log.info("test with log4j");
        System.out.println("ThreadContext value :" + ThreadContext.get("MDCTest"));
        return ThreadContext.get("MDCTest");
    }

}