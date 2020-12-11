package init.mg.app.helper

import java.io.File
import java.io.FileWriter

class FileUtil {

    companion object{
        fun saveToTypeSafe (targetFile : File, objectToWrite : String) : Unit{
            val fileWriter = FileWriter(targetFile)
            fileWriter.write(objectToWrite)
            fileWriter.flush();
            fileWriter.close();
        }
    }
}