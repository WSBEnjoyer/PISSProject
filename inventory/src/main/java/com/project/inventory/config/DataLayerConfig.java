package com.project.inventory.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.project.inventory" })
@EnableJpaRepositories(basePackages = { "com.project.inventory" })
@Configuration
public class DataLayerConfig {
}
