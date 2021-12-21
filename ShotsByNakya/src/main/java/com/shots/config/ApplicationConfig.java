package com.shots.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.shots.repository")
@EntityScan(basePackages="com.shots.entity")
public class ApplicationConfig {

}
