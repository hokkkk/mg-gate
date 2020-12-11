package init.mg.app.service

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigValueFactory
import init.mg.app.helper.ConfigFile
import init.mg.app.helper.FileUtil
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.app.AppSetting
import init.mg.app.payload.app.PlatformDetail
import init.mg.app.payload.app.RequestCreateAppSetting
import init.mg.app.payload.enum.MobileOs
import init.mg.app.payload.project.Info
import init.mg.app.payload.project.ProjectInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.Throws


@Service
class AppService {


    fun getConfig(projectId : String , os: MobileOs) : Config {
        var parent :  String = ConfigFile.PARENT_PATH
        val appSetting : Config  =  ConfigFactory.parseFile( File(parent, "$projectId.conf") )
        return appSetting.getConfig(os.value);
    }

    @Throws(Exception::class)
    fun createConfig( projectId : String ,appSetting: RequestCreateAppSetting) : String  {
        ConfigFactory.invalidateCaches();

        val targetFile = File(ConfigFile.PARENT_PATH,"$projectId.conf")
        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gson.toJson(appSetting))

        return projectId;

    }
//    @Throws(Exception::class)
//    fun putConfig( projectId: String ,os : MobileOs ,platformDetail: PlatformDetail  ) : Unit {
//        ConfigFactory.invalidateCaches();
//
//        val appSetting : AppSetting  =  ConfigFactory.parseFile( File( ConfigFile.PARENT_PATH, "$projectId.conf") )
//        if(MobileOs.IOS.equals(os))
//            appSetting.
//        else
//    }


}