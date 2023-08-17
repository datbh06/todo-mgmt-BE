package com.yugen.todomgmtbe;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot application for managing Todo items.
 */
@SpringBootApplication
public class TodoMgmtBeApplication {

    /**
     * Creates a new ModelMapper bean.
     *
     * @return the created ModelMapper bean
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TodoMgmtBeApplication.class, args);
    }

}
