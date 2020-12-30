package init.mg.app.service

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigRenderOptions
import init.mg.app.exception.BusinessException
import init.mg.app.helper.ConfigFile
import init.mg.app.helper.FileUtil
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.*
import init.mg.app.payload.enum.MobileOs
import init.mg.app.payload.setting.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import javax.servlet.http.HttpServletRequest


@Service
class SettingService {
    @Autowired
    lateinit var request: HttpServletRequest;

    @Throws(Exception::class)
    fun getConfig(appId: String, os: MobileOs) : String {

      try{

          val config : Config  =  ConfigFactory.parseFile(File(ConfigFile.CONF_FILE_PARENT_PATH, "$appId.conf"))
          val responseStr = config.getConfig(os.value).root().render(ConfigRenderOptions.concise())

          if(!"km".equals(request.locale.toLanguageTag()) )   return responseStr;

          val platformDetail : PlatformDetail? = PlatformDetail.getDetail(responseStr)
          platformDetail?.switchToKm();
          return platformDetail.toString();
      }catch (ex : Throwable){
          ex.printStackTrace()
          throw BusinessException(ErrorCode.FILE_NOT_FOUND)
      }
    }

    @Throws(Exception::class)
    fun getRawConfig(appId: String, os: MobileOs) : String {
        try{
            val config : Config  =  ConfigFactory.parseFile(File(ConfigFile.CONF_FILE_PARENT_PATH, "$appId.conf"));
            return config.getConfig(os.value).root().render(ConfigRenderOptions.concise());
        }catch (ex : Throwable){
            ex.printStackTrace();
            throw BusinessException(ErrorCode.FILE_NOT_FOUND);
        }
    }


    @Throws(Exception::class)
    fun createConfig(appId: String, appSetting: RequestCreateAppSetting) : String  {
        ConfigFactory.invalidateCaches();

        val targetFile = File(ConfigFile.CONF_FILE_PARENT_PATH, "$appId.conf")
        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gson.toJson(appSetting))

        return appId;

    }

    @Throws(Exception::class)
    fun createConfig(appId: String, appSetting: AppDynasmicSetting) : String  {
        ConfigFactory.invalidateCaches();

        val targetFile = File(ConfigFile.CONF_FILE_PARENT_PATH, "$appId.conf")
        FileUtil.saveToTypeSafe(targetFile, ObjectUtil.gson.toJson(appSetting))

        return appId;

    }

    @Throws(Exception::class)
    fun putConfig(appId: String, reqAppSetting: RequestUpdateAppSetting) : Unit {

        ConfigFactory.invalidateCaches();

        var targetFile = File(ConfigFile.CONF_FILE_PARENT_PATH, "$appId.conf")
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