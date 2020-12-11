package init.mg.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMethod

@CrossOrigin( origins = ["*"], allowedHeaders = ["*"], methods = [RequestMethod.GET , RequestMethod.POST])
@SpringBootApplication
class WeappApplication

fun main(args: Array<String>) {
	runApplication<WeappApplication>(*args)
}
