package init.mg.app.controller

import com.google.gson.FieldNamingPolicy
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigRenderOptions
import init.mg.app.helper.ConfigFile
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.app.AppSetting
import init.mg.app.payload.app.RequestCreateAppSetting
import init.mg.app.payload.enum.MobileOs
import init.mg.app.payload.project.ProjectInfo
import init.mg.app.service.AppService
import init.mg.app.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.File
import java.util.*


@RestController
class AppController : CommonController<Any>() {

    @Autowired
    private lateinit var appService : AppService;


    @GetMapping("/api/app/setting/{project-id}")
    fun getApp(@PathVariable("project-id") projectId : String ,
                @RequestParam(value ="os" , required = true) os : MobileOs
    ) : ResponseEntity<Any>? {
        ConfigFactory.invalidateCaches();
        val appSetting : Config = appService.getConfig(projectId,os)
        return ok(appSetting.root().render(ConfigRenderOptions.concise()));
    }




}