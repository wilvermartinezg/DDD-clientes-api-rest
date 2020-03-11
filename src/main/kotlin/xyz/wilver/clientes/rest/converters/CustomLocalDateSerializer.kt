package xyz.wilver.clientes.rest.converters

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CustomLocalDateSerializer(t: Class<LocalDate>? = null) : StdSerializer<LocalDate>(t) {

    private val format = "yyyy-MM-dd"
    private val formatter = DateTimeFormatter.ofPattern(format)

    @Throws(IOException::class)
    override fun serialize(value: LocalDate, gen: JsonGenerator, arg2: SerializerProvider) {
        gen.writeString(formatter.format(value))
    }
}
