package init.mg.app.payload.setting

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import lombok.Getter
import lombok.Setter
import java.util.*

//@ToString

@Getter
@Setter
class PlatformDetail {

    @SerializedName("c_available_service")
    @JsonProperty("c_available_service")
    private val availableService: Boolean? = null

    @JsonProperty("c_act_ser_msg")
    @SerializedName("c_act_ser_msg")
    private val act: String? = null

    @JsonProperty("c_act_ser_msg_km")
    @SerializedName("c_act_ser_msg_km")
    private val actKm: String? = null

    @JsonProperty("c_act_yn")
    @SerializedName("c_act_yn")
    private val actYn: Boolean? = null

    @JsonProperty("c_act_msg")
    @SerializedName("c_act_msg")
    private val actMsg: String? = null

    @JsonProperty("c_act_msg_km")
    @SerializedName("c_act_msg_km")
    private val actMsgKm: String? = null

    @JsonProperty("c_program_ver")
    @SerializedName("c_program_ver")
    private val programVer: String? = null

    @JsonProperty("c_appstore_url")
    @SerializedName("c_appstore_url")
    private val appstoreUrl: String? = null


    @JsonProperty("_master_id")
    @SerializedName("_master_id")
    private val masterId: String? = null

    @JsonProperty("c_start_url")
    @SerializedName("c_start_url")
    private val startUrl: String? = null


    @JsonProperty("_menu_info")
    @SerializedName("_menu_info")
    private val buildInfos: List<MenuInfo> = ArrayList<MenuInfo>()
//    override fun toString(): String {
//        return "PlatformDetail(availableService=$availableService, act=$act, actYn=$actYn, actMsg=$actMsg, programVer=$programVer, appstoreUrl=$appstoreUrl, masterId=$masterId, startUrl=$startUrl, buildInfos=$buildInfos)"
//    }

}