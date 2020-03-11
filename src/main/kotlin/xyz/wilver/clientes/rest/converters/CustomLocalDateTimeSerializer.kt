package xyz.wilver.clientes.rest.converters

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CustomLocalDateTimeSerializer(t: Class<LocalDateTime>? = null) : StdSerializer<LocalDateTime>(t) {

    private val format = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    private val formatter = DateTimeFormatter.ofPattern(format)

    @Throws(IOException::class)
    override fun serialize(value: LocalDateTime, gen: JsonGenerator, arg2: SerializerProvider) {
        gen.writeString(formatter.format(value))
    }
}
