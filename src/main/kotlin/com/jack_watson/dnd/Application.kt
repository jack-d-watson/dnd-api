
package com.jack_watson.dnd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.jack_watson")
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

