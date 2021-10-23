package com.tutrit.registerservice;

import com.tutrit.register.gateway.GateWayI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterServiceApplication {
    private static GateWayI gateWayI;

    public static void main(String[] args) {
        SpringApplication.run(RegisterServiceApplication.class, args);
    }
}
