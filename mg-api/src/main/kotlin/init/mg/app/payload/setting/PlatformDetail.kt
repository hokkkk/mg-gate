package init.mg.app.payload.setting

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.google.gson.annotations.SerializedName
import init.mg.app.helper.ObjectUtil
import init.mg.app.payload.CommonPayload
import lombok.Getter
import lombok.Setter
import java.util.*

//@ToString

@Getter
@Setter
class PlatformDetail : CommonPayload() {

    @SerializedName("c_available_service")
    @JsonProperty("c_available_service")
    var availableService: Boolean? = null

    @JsonProperty("c_act_ser_msg")
    @SerializedName("c_act_ser_msg")
    var act: String? = null

    @JsonProperty("c_act_ser_msg_km")
    @SerializedName("c_act_ser_msg_km")
    var actKm: String? = null

    @JsonProperty("c_act_yn")
    @SerializedName("c_act_yn")
    var actYn: Boolean? = null

    @JsonProperty("c_act_msg")
    @SerializedName("c_act_msg")
    var actMsg: String? = null

    @JsonProperty("c_act_msg_km")
    @SerializedName("c_act_msg_km")
    var actMsgKm: String? = null

    @JsonProperty("c_program_ver")
    @SerializedName("c_program_ver")
    var programVer: String? = null

    @JsonProperty("c_appstore_url")
    @SerializedName("c_appstore_url")
    var appstoreUrl: String? = null


    @JsonProperty("_master_id")
    @SerializedName("_master_id")
    var masterId: String? = null

    @JsonProperty("c_start_url")
    @SerializedName("c_start_url")
    var startUrl: String? = null


    @JsonProperty("_menu_info")
    @SerializedName("_menu_info")
    val buildInfos: List<MenuInfo> = ArrayList<MenuInfo>()
//    override fun toString(): String {
//        return "PlatformDetail(availableService=$availableService, act=$act, actYn=$actYn, actMsg=$actMsg, programVer=$programVer, appstoreUrl=$appstoreUrl, masterId=$masterId, startUrl=$startUrl, buildInfos=$buildInfos)"
//    }

    fun switchToKm () :Unit {
        this.actMsg = actMsgKm;
        this.act = actKm;
    }
    companion object {

        fun getDetail(jsonString: String?): PlatformDetail? {
            return ObjectUtil.readValue(jsonString, object : TypeReference<PlatformDetail>() {})
        }
    }
}