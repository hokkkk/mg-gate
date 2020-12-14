package init.mg.app.exception
import org.springframework.http.HttpStatus

data class ApiError(
        var status: HttpStatus,
        var clientMessage: String,
        var errors: List<String>?,
        var developerMessage: String? = null
){
    constructor(status: HttpStatus, clientMessage: String, error: String, developerMessage: String? = null) :
            this(status, clientMessage, arrayListOf<String>(error), developerMessage)

    constructor( status : HttpStatus,  message : String) : this (status,message,null,null)
}