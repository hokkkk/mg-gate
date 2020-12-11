//package init.weums.app.configure
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.config.web.servlet.invoke
//
//@EnableWebSecurity
//class SecurityConfig : WebSecurityConfigurerAdapter() {
//
//    override fun configure(http: HttpSecurity?) {
//         http  {
//             httpBasic {}
//             authorizeRequests {
////                 authorize("/greetings/**", hasAuthority("ROLE_ADMIN"))
//                 authorize(permitAll)
//             }
//         }
//    }
//}