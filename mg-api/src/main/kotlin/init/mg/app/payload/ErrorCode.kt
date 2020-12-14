package init.mg.app.payload

import org.springframework.http.HttpStatus


enum class ErrorCode(val status: HttpStatus,
                     val message: String) {

    FORBIDDEN_TRANSACTION(HttpStatus.FORBIDDEN, "Requested transaction is forbidden"),



    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "File is not found"),





}
