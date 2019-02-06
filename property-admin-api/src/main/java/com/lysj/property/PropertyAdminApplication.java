package com.lysj.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PropertyAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertyAdminApplication.class, args);
    }
}
