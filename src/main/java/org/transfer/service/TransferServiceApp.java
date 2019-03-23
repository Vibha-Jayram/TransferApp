package org.transfer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is the entry point for Transfer Service Application
 * @author Vibha
 *
 */

@SpringBootApplication(scanBasePackages = {"org.transfer.service"} , exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages="org.transfer.service")
@EntityScan("org.transfer.service.entity")
@EnableJpaRepositories("org.transfer.service.dao")


public class TransferServiceApp {

    /**
     * @param args list of input argument for starting of the application
     */
    public static void main(String[] args) {
        SpringApplication.run(TransferServiceApp.class, args);
    }
}
