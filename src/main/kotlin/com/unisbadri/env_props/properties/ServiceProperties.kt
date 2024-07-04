package com.unisbadri.env_props.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.service")
class ServiceProperties(
    val name: String
)