package init.mg.app.controller

import init.mg.app.payload.setting.RequestCreateAppSetting
import init.mg.app.service.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AppController : CommonController<Any>(){
    @Autowired
    private lateinit  var appService : AppService

    @GetMapping("/api/app")
    fun getProjectInfo() : Any? {
        return appService.loadApp();
    }

    @PostMapping( "/api/app/{app-name}")
    fun createApp(
            @PathVariable("app-name") pName : String ,
            @RequestBody appSetting : RequestCreateAppSetting
    ) : ResponseEntity<Any>? {
        return ok(appService.createApplication(pName,appSetting))

    }
}