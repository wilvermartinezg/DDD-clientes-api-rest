package xyz.wilver.clientes.rest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import xyz.wilver.clientes.api.CustomerApi
import xyz.wilver.clientes.domain.services.CustomerBalanceService
import xyz.wilver.clientes.domain.services.CustomerService
import xyz.wilver.clientes.infrastructure.InfraConfiguration
import xyz.wilver.clientes.infrastructure.services.EmailService

@Configuration
@Import(value = [InfraConfiguration::class])
class RestConfiguration {

    @Bean
    fun customerApi(
        customerService: CustomerService,
        customerBalanceService: CustomerBalanceService,
        emailService: EmailService
    ): CustomerApi {
        return CustomerApi(customerService, customerBalanceService, emailService)
    }

}

