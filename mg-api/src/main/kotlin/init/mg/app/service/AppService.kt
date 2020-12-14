package init.mg.app.service

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigRenderOptions
import init.mg.app.exception.BusinessException
import init.mg.app.helper.ConfigFile
import init.mg.app.helper.FileUtil
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.*
import init.mg.app.payload.app.AppSetting
import init.mg.app.payload.app.RequestCreateAppSetting
import init.mg.app.payload.app.RequestUpdateAppSetting
import init.mg.app.payload.enum.MobileOs
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileNotFoundException



@Service
class AppService {

    @Throws(Exception::class)
    fun getConfig(projectId: String, os: MobileOs) : Config {

      try{
          var parent :  String = ConfigFile.CONF_FILE_PARENT_PATH
          val appSetting : Config  =  ConfigFactory.parseFile(File(parent, "$projectId.conf"))
          return appSetting.getConfig(os.value);
      }catch (ex : Throwable){
          throw BusinessException(ErrorCode.FILE_NOT_FOUND)
      }
    }

    @Throws(Exception::class)
    fun createConfig(projectId: String, appSetting: RequestCreateAppSetting) : String  {
        ConfigFactory.invalidateCaches();

        val targetFile = File(ConfigFile.CONF_FILE_PARENT_PATH, "$projectId.conf")
        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gson.toJson(appSetting))

        return projectId;

    }

    @Throws(Exception::class)
    fun putConfig(projectId: String, reqAppSetting: RequestUpdateAppSetting) : Unit {
        ConfigFactory.invalidateCaches();
        var targetFile = File(ConfigFile.CONF_FILE_PARENT_PATH, "$projectId.conf")
        var config = ConfigFactory.parseFile(targetFile);
        var appSetting = AppSetting.getAppSetting(config.root().render(ConfigRenderOptions.concise()))

        if (appSetting != null) {
            if (MobileOs.IOS.equals(reqAppSetting.os))
                appSetting.ios = reqAppSetting.platformDetail;
            else
                appSetting.aos = reqAppSetting.platformDetail;
            FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gson.toJson(appSetting))
        } else {
            throw BusinessException(ErrorCode.FILE_NOT_FOUND)
        }

    }
}