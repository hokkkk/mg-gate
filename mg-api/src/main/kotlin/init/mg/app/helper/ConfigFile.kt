package init.mg.app.helper

import com.typesafe.config.ConfigBeanFactory
import com.typesafe.config.ConfigFactory
import init.mg.app.payload.project.ProjectInfo
import java.io.File

class ConfigFile {

    companion object {
        var PARENT_PATH : String;
        var PROJECT_INFO : String =  "project-info.conf";
        init {

            var parent : String = File(System.getProperty("config.file")).parent;
            PARENT_PATH = parent
        }

        inline fun <reified T> load (configName : String) : T {
            var conf  =  ConfigFactory.load().getConfig(configName)
            var pInfo =  ConfigBeanFactory.create(conf, T::class.java);
            return pInfo;
        }
    }
}