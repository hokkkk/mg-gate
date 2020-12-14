package init.mg.app.controller

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigRenderOptions
import init.mg.app.payload.*
import init.mg.app.payload.app.PlatformDetail
import init.mg.app.payload.app.RequestUpdateAppSetting
import init.mg.app.payload.enum.MobileOs
import init.mg.app.service.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.InvalidMediaTypeException
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.io.FileNotFoundException
import java.util.*
import javax.validation.Valid;

@RestController
class AppController : CommonController<Any>() {

    @Autowired
    private lateinit var appService : AppService;


    @GetMapping("/api/app/setting/{app_id}")
    @Throws(Exception::class)
    fun getApp(@PathVariable("app_id") appId: String,
               @RequestParam(value = "os", required = true) os: MobileOs
    ) : ResponseEntity<*>? {

            ConfigFactory.invalidateCaches();
            val appSetting : Config = appService.getConfig(appId, os)
            return ok(appSetting.root().render(ConfigRenderOptions.concise()));

    }


    @Throws(Exception::class)
    @PutMapping("/api/app/setting/{app_id}")
    fun putApp(   @PathVariable("app_id") appId: String,
                 @RequestParam("os", required = true) os : MobileOs,
              @Valid @RequestBody platformDetail : PlatformDetail): Unit {

            appService.putConfig(appId, RequestUpdateAppSetting(os,platformDetail))

    }

}