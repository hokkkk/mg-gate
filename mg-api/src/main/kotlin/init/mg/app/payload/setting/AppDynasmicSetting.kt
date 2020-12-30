package init.mg.app.payload.setting

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.google.gson.annotations.SerializedName
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.CommonPayload
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.validation.constraints.NotNull

class AppDynasmicSetting (

    @SerializedName("IOS")
    @JsonProperty("IOS")
    @NotNull
     var ios  : HashMap<String,Object>,

    @SerializedName("AOS")
    @JsonProperty("AOS")
    @NotNull
     var aos : HashMap<String,Object>
){
    companion object {

        fun getAppSetting(jsonString: String?): AppDynasmicSetting? {
            return ObjectUtil.readValue(jsonString, object : TypeReference<AppDynasmicSetting>() {})
        }
    }
}