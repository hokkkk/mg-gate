package init.mg.app.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import init.mg.app.helper.ConfigFile
import init.mg.app.helper.FileUtil
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.app.AppSetting
import init.mg.app.payload.app.RequestCreateAppSetting
import init.mg.app.payload.project.Info
import init.mg.app.payload.project.ProjectInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.Throws

@Service
class ProjectService {
    @Autowired
    lateinit var appService : AppService;
    open fun loadProject() : ProjectInfo? {

        return ConfigFile.load<ProjectInfo>("project");
    }

    @Throws(Exception::class)
    fun createProject(appName : String , appSetting : RequestCreateAppSetting) : Info {
        var info  = Info();
        val appId = UUID.randomUUID().toString();

        info.projectName = appName;
        info.projectId = appService.createConfig(appId,appSetting)

        createNewProject(info)
        return info;
    }

    fun createNewProject(info : Info) : Info? {
        var projectInfo  =  loadProject();
        println(info)
        projectInfo?.info?.add(info);
        val targetFile = File(ConfigFile.PARENT_PATH, ConfigFile.PROJECT_INFO);

        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gsonCamel.toJson(projectInfo))

        return info;
    }


}