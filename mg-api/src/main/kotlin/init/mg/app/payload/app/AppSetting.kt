package init.mg.app.payload.app

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.google.gson.annotations.SerializedName
import init.mg.app.helper.ObjectUtil
import lombok.Getter
import lombok.Setter
import lombok.ToString

@ToString
@Getter
@Setter
open class AppSetting {

    @SerializedName("IOS")
    @JsonProperty("IOS")
    public var ios : PlatformDetail = PlatformDetail();

    @SerializedName("AOS")
    @JsonProperty("AOS")
    public var aos : PlatformDetail = PlatformDetail();

    constructor()  {

    }

    companion object {

        fun getAppSetting(jsonString: String?): AppSetting? {
            return ObjectUtil.readValue(jsonString, object : TypeReference<AppSetting>() {})
        }
    }




    override fun toString(): String {
        return ObjectUtil.writeValueAsString(this)
    }
}