package xyz.wilver.clientes.rest.converters

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.io.IOException
import java.time.LocalDateTime

class CustomLocalDateTimeDeserializer(t: Class<LocalDateTime>? = null) : StdDeserializer<LocalDateTime>(t) {

    @Throws(IOException::class)
    override fun deserialize(jsonParser: JsonParser?, p1: DeserializationContext?): LocalDateTime {
        return LocalDateTime.parse(jsonParser?.readValueAs(String::class.java))
    }

}
