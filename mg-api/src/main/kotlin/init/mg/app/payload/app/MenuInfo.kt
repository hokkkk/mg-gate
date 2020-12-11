package init.mg.app.payload.app

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter


@Getter
@Setter
class MenuInfo {
    @JsonProperty("c_menu_id")
    private val menuInfo: String? = null

    @JsonProperty("c_menu_title")
    private val menuTitle: String? = null

    @JsonProperty("c_avaailable")
    private val available: Boolean? = null

    @JsonProperty("c_menu_type")
    private val menuType: Int? = null

    @JsonProperty("c_menu_url")
    private val menuUrl: String? = null

    @JsonProperty("c_menu_no")
    private val menuNo: Int? = null

    @JsonProperty("c_reason")
    private val reason: String? = null
}