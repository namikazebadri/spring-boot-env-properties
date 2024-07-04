package com.unisbadri.env_props

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class EnvPropsApplication

fun main(args: Array<String>) {
	runApplication<EnvPropsApplication>(*args)
}
