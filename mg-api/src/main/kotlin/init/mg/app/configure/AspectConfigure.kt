package init.mg.app.configure

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class AspectConfigure {
    @Before("execution(* init.mg.app.*.*.*(..)) ")
    fun level1() : Unit {}

    @Before("execution(* init.mg.app.*.*.*.*(..)) ")
    fun level2() : Unit {}

    @Before("execution(* init.mg.app.*.*.*(..))  || execution(* init.mg.app.*.*.*.*(..)) ")
    fun before(joinPoint: JoinPoint) : Unit {

        val method = joinPoint.signature.name
        println("[ $method starts ]")
    }
}