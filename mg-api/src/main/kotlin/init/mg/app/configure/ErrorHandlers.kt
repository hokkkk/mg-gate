//package init.mg.app.configure
//
//import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import init.mg.app.exception.ApiError
//import org.springframework.core.Ordered
//import org.springframework.core.annotation.Order
//import org.springframework.http.HttpStatus
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.bind.annotation.ResponseStatus
//import org.springframework.web.bind.annotation.RestControllerAdvice
//import javax.servlet.http.HttpServletResponse
//import javax.validation.ConstraintViolationException
//
//@RestControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
//class ErrorHandlers {
//    private val mapper = jacksonObjectMapper()
//
//    @ExceptionHandler(ConstraintViolationException::class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    fun badRequest(res: HttpServletResponse, ex: Exception): ApiError {
//        ex.printStackTrace()
//        return badRequest(ex)
//    }
//    @ExceptionHandler(InvalidRequestException::class)
//    fun invalidRequest(res: HttpServletResponse, ex: InvalidRequestException): ApiError {
//        logger.warn(ex.toString())
//        val json = mapper.readTree(ex.message)
//        val key = json["messages"][0]["key"].asText()
//
//        val message = json["messages"].map { m ->
//            val body = m["message"].asText()
//            val prefix = m["context"]["parameter"]?.let {
//                val name = it.get("name")?.asText() ?: ""
//                val inType = it.get("in")?.let {
//                    " (in ${it.asText()})"
//                } ?: ""
//                "$name$inType: "
//            } ?: ""
//            "$prefix$body"
//        }.joinToString(" and ")
//
//        return if (key == "validation.request.path.missing") {
//            res.status = 404
//            ApiError.notFound(message)
//        } else {
//            res.status = 400
//            badRequest(message)
//        }
//    }
//
//    @ExceptionHandler(InvalidResponseException::class)
//    fun invalidResponse(res: HttpServletResponse, ex: InvalidResponseException): ApiError {
//        logger.error(ex.toString())
//        val json = mapper.readTree(ex.message)
//        val message = json["messages"][0]["message"].asText()
//        return internalServerError("response validation error: $message")
//    }
//
//    @ExceptionHandler(ApiError::class)
//    fun apiError(res: HttpServletResponse, ex: ApiError): ApiError {
//        ex.printStackTrace()
//        res.status = when (ex) {
//            is ApiErrorWcp -> ex.status.code
//            is ApiErrorBasic -> ex.code
//            else -> {
//                ex.addSuppressed(Exception("unknown ApiError type"))
//                500
//            }
//        }
//        return ex
//    }
//
//
//}