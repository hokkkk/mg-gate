package init.mg.app.service

import init.mg.app.helper.ConfigFile
import init.mg.app.helper.FileUtil
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.setting.RequestCreateAppSetting
import init.mg.app.payload.app.Info
import init.mg.app.payload.app.AppInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.util.*
import kotlin.Throws

@Service
class AppService {
    @Autowired
    lateinit var appService : SettingService;
    open fun loadApp() : AppInfo? {

        return ConfigFile.load<AppInfo>("project");
    }

    @Throws(Exception::class)
    fun createProject(appName : String , appSetting : RequestCreateAppSetting) : Info {
        var info  = Info();
        val appId = UUID.randomUUID().toString();

        info.appName = appName;
        info.appId = appService.createConfig(appId,appSetting)

        createNewProject(info)
        return info;
    }

    fun createNewProject(info : Info) : Info? {
        var appInfo  =  loadApp();
        println(info)
        appInfo?.info?.add(info);
        val targetFile = File(ConfigFile.PARENT_PATH, ConfigFile.PROJECT_INFO);

        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gsonCamel.toJson(appInfo))

        return info;
    }


}