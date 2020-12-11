package init.mg.app.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


abstract class CommonController<T> {

    open fun <T> buildResponse(status: HttpStatus?, data: T): ResponseEntity<T>? {
        return buildResponse(status, data, HttpHeaders())
    }


    open fun <T> buildResponse(status: HttpStatus?, data: T?, headers: HttpHeaders?): ResponseEntity<T>? {

        //        headers.add("Custom-Header", "foo");
        return if (data == null) {
            ResponseEntity.ok().headers(headers).build()
        } else ResponseEntity(data, headers, HttpStatus.OK)
    }

    open fun <T> ok(data: T): ResponseEntity<T>? {
        return buildResponse(HttpStatus.OK, data)
    }

}