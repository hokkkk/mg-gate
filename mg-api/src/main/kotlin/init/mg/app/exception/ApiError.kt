package init.mg.app.exception
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatus

data class ApiError(
        var code: HttpStatus,
        var message: String,
        var errors: List<String>?,
        @JsonProperty("debug_message")
        var debugMessage: String? = null
){
    constructor(status: HttpStatus, message: String, error: String, developerMessage: String? = null) :
            this(status, message, arrayListOf<String>(error), developerMessage)

    constructor( status : HttpStatus,  message : String) : this (status,message,null,null)
}