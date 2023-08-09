package com.met.identityservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
class IdentityServiceApplication

fun main(args: Array<String>) {
    runApplication<IdentityServiceApplication>(*args)
}
