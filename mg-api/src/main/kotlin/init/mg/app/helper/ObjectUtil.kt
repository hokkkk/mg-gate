package init.mg.app.helper

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder


class ObjectUtil {

    companion object{
        var gson : Gson = GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .setPrettyPrinting().create()

        var gsonCamel : Gson = GsonBuilder()

                                .setPrettyPrinting()
                                .create()
        var mapper : ObjectMapper;

        init {
            mapper = ObjectMapper()
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            mapper.setSerializationInclusion(Include.NON_NULL)
            mapper.enable(SerializationFeature.INDENT_OUTPUT)
        }

        fun <T> readValue(str: String?, tr: TypeReference<T>?): T? {
            try {
                return mapper.readValue(str, tr)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        fun writeValueAsString(value: Any?): String {
            try {
                return mapper.writeValueAsString(value)
            } catch (e: JsonProcessingException) {
                e.printStackTrace()
            }
            return ""
        }
    }

}