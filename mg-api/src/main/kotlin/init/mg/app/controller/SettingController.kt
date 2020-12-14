package init.mg.app.controller

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigRenderOptions
import init.mg.app.payload.setting.PlatformDetail
import init.mg.app.payload.setting.RequestUpdateAppSetting
import init.mg.app.payload.enum.MobileOs
import init.mg.app.service.SettingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid;

@RestController
class SettingController : CommonController<Any>() {

    @Autowired
    private lateinit var settingService : SettingService;


    @GetMapping("/api/app/setting/{app_id}")
    @Throws(Exception::class)
    fun getApp(@PathVariable("app_id") appId: String,
               @RequestParam(value = "os", required = true) os: MobileOs
    ) : ResponseEntity<*>? {

            ConfigFactory.invalidateCaches();
            val appSetting : Config = settingService.getConfig(appId, os)
            return ok(appSetting.root().render(ConfigRenderOptions.concise()));

    }


    @Throws(Exception::class)
    @PutMapping("/api/app/setting/{app_id}")
    fun putApp(   @PathVariable("app_id") appId: String,
                 @RequestParam("os", required = true) os : MobileOs,
              @Valid @RequestBody platformDetail : PlatformDetail): Unit {

            settingService.putConfig(appId, RequestUpdateAppSetting(os,platformDetail))

    }

}