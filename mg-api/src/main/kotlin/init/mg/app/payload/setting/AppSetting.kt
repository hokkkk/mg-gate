package init.mg.app.payload.setting

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.google.gson.annotations.SerializedName
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.CommonPayload
import lombok.Getter
import lombok.Setter
import lombok.ToString

@ToString
@Getter
@Setter
open class AppSetting :  CommonPayload() {

    @SerializedName("IOS")
    @JsonProperty("IOS")
    public var ios : PlatformDetail = PlatformDetail();

    @SerializedName("AOS")
    @JsonProperty("AOS")
    public var aos : PlatformDetail = PlatformDetail();


    companion object {

        fun getAppSetting(jsonString: String?): AppSetting? {
            return ObjectUtil.readValue(jsonString, object : TypeReference<AppSetting>() {})
        }
    }


}