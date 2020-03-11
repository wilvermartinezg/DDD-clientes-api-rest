package xyz.wilver.clientes.rest

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan(value = ["xyz.wilver.clientes.rest"])
@EnableTransactionManagement
class RestApplication

fun main(args: Array<String>) {
    runApplication<RestApplication>(*args)
}
