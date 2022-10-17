package com.example.springguidefirst.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

//    @Bean
//    public DataSource dataSource () {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("DB_URL=jdbc:mysql://localhost:3306/conference_demo?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true;DB_UN=root;DB_PW=RandomPassword123!");
//        return builder.build();
//    }

}
