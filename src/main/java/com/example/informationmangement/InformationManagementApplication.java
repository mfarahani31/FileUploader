package com.example.informationmangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InformationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InformationManagementApplication.class, args);
    }

}
