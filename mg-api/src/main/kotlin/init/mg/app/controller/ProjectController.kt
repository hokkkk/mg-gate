package init.mg.app.controller

import init.mg.app.payload.app.RequestCreateAppSetting
import init.mg.app.payload.project.ProjectInfo
import init.mg.app.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProjectController : CommonController<Any>(){
    @Autowired
    private lateinit  var projectService : ProjectService

    @GetMapping("/api/app")
    fun getProjectInfo() : Any? {
        return projectService.loadProject();
    }

    @PostMapping( "/api/app/{app-name}")
    fun createApp(
            @PathVariable("app-name") pName : String ,
            @RequestBody appSetting : RequestCreateAppSetting
    ) : ResponseEntity<Any>? {
        return ok(projectService.createProject(pName,appSetting))

    }
}