package xyz.wilver.clientes.rest.controllers.customer.create

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.wilver.clientes.api.CustomerApi
import xyz.wilver.clientes.presentation.CustomerCreationRequest

@RestController
@RequestMapping(value = ["/api/customer"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CustomerCreationController {

    @Autowired
    private lateinit var customerApi: CustomerApi

    @PostMapping
    @Transactional
    fun createCustomer(@RequestBody requestBody: CustomerCreationJSONRequest): ResponseEntity<Long> {

        val customerCreationRequest = CustomerCreationRequest().apply {
            this.companyId = requestBody.companyId
            this.customerName = requestBody.customerName
            this.customerLastName = requestBody.customerLastName
            this.customerBirthdate = requestBody.customerBirthdate
            this.customerEmail = requestBody.customerEmail
            this.customerGender = requestBody.customerGender
            this.customerFullAddress = requestBody.customerFullAddress
            this.customerDocumentNumber = requestBody.customerDocumentNumber
            this.customerDocumentType = requestBody.customerDocumentType
        }

        val customerId = customerApi.createCustomer(customerCreationRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body(customerId)
    }

}
