package xyz.wilver.clientes.rest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotFoundException
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotPersistedException
import xyz.wilver.clientes.presentation.UserInputValuesException

@ControllerAdvice
class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(UserInputValuesException::class)
    fun userInputValuesExceptionHandler(ex: UserInputValuesException): ResponseEntity<UserInputValueErrorJSONPayload> {
        val errors = ex
            .errors
            .map { UserInputValueErrorJSON(it.code, it.field, it.description) }

        return ResponseEntity.badRequest().body(UserInputValueErrorJSONPayload(errors))
    }

    @ResponseBody
    @ExceptionHandler(EntityNotPersistedException::class)
    fun entityNotPersistedExceptionHandler(ex: EntityNotPersistedException): ResponseEntity<Map<String, String>> {
        val response = mutableMapOf<String, String>()
        response["title"] = "EntityNotPersistedException"
        response["message"] = ex.message ?: "Entidad no persistida"

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(response)
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException::class)
    fun entityNotFoundExceptionHandler(ex: EntityNotFoundException): ResponseEntity<Map<String, String>> {
        val response = mutableMapOf<String, String>()
        response["title"] = "EntityNotFoundException"
        response["message"] = ex.message ?: "Entidad no encontrada"

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

}
