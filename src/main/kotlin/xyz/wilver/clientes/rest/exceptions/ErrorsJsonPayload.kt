package xyz.wilver.clientes.rest.exceptions

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserInputValueErrorJSON(var code: String, var field: String, var description: String)

data class UserInputValueErrorJSONPayload(var errors: List<UserInputValueErrorJSON>)
