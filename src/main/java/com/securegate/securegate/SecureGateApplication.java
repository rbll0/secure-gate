package com.securegate.securegate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
@EnableMongoRepositories(basePackages = "com.securegate.securegate.gateways.repositories")
public class SecureGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureGateApplication.class, args);
        System.out.println("\uD83D\uDE80 SecureGate backend iniciado com sucesso!");
    }
}
