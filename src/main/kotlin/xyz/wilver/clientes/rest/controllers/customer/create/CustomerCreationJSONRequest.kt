package xyz.wilver.clientes.rest.controllers.customer.create

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import xyz.wilver.clientes.rest.converters.CustomLocalDateDeserializer
import xyz.wilver.clientes.rest.converters.CustomLocalDateSerializer
import java.time.LocalDate

class CustomerCreationJSONRequest {
    var companyId = 0L
    var customerName = ""
    var customerLastName = ""

    @JsonSerialize(using = CustomLocalDateSerializer::class)
    @JsonDeserialize(using = CustomLocalDateDeserializer::class)
    var customerBirthdate: LocalDate = LocalDate.now()

    var customerEmail = ""
    var customerGender = "" // MALE OR FEMALE
    var customerFullAddress = ""
    var customerDocumentNumber = ""
    var customerDocumentType = ""
}
