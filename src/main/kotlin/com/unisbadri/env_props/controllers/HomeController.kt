package com.unisbadri.env_props.controllers

import com.unisbadri.env_props.properties.ServiceProperties
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/")
class HomeController(
    private val environment: Environment,
    private val serviceProperties: ServiceProperties,
    @Value("\${app.service.name}")
    private val serviceName: String,
    @Value("\${app.service.version}")
    private val serviceVersion: String,
    @Value("\${app.service.author:Unis Badri}")
    private val serviceAuthor: String
) {
    @GetMapping("")
    fun index(): String {
        return """
            <p style="line-height:1.5">
                <strong>Service Name</strong>: $serviceName<br/>
                <strong>Service Name (from Environment class)</strong>: ${environment.getProperty("app.service.name")}<br/>
                <strong>Service Name (from ConfigurationProperties class)</strong>: ${serviceProperties.name}<br/>
                <strong>Service Version (from env with default value in properties)</strong>: $serviceVersion<br/>
                <strong>Service Author</strong>: $serviceAuthor
            </p>
        """.trimIndent()
    }
}