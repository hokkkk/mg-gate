package init.mg.app.configure

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class AspectConfigure {

    var logger : Logger = LoggerFactory.getLogger(AspectConfigure::class.java)


    @Before("execution(* init.mg.app.*.*.*(..)) ")
    fun level1() : Unit {}

    @Before("execution(* init.mg.app.*.*.*.*(..)) ")
    fun level2() : Unit {}

    @Before("execution(* init.mg.app.*.*.*(..))  || execution(* init.mg.app.*.*.*.*(..)) ")
    fun before(joinPoint: JoinPoint) : Unit {

        val method = joinPoint.signature.name
        logger.info("{ Methods => $method starts }")
    }
}