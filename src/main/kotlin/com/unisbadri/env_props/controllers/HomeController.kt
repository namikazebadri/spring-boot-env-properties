package com.unisbadri.env_props.controllers

import com.unisbadri.env_props.properties.ServiceProperties
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/")
class HomeController(
    private val environment: Environment, // using environment class
    private val serviceProperties: ServiceProperties, // from configuration properties
    @Value("\${app.service.name}") // properties without default value
    private val serviceName: String,
    @Value("\${app.service.version}") // default value defined in properties file
    private val serviceVersion: String,
    @Value("\${app.service.author:Unis Badri}") //default value defined in @Value
    private val serviceAuthor: String
) {
    @GetMapping("")
    fun index(): String {
        return """
            <p style="line-height:1.5">
                <strong>Service Name</strong>: $serviceName<br/>
                <strong>Service Name (from Environment class)</strong>: ${environment.getProperty("app.service.name")}<br/>
                <strong>Service Address (from Environment class with default value)</strong>: ${environment.getProperty("app.service.address", "127.0.0.1")}<br/>
                <strong>Service Name (from ConfigurationProperties class)</strong>: ${serviceProperties.name}<br/>
                <strong>Service Version (from env with default value in properties)</strong>: $serviceVersion<br/>
                <strong>Service Author</strong>: $serviceAuthor
            </p>
        """.trimIndent()
    }
}