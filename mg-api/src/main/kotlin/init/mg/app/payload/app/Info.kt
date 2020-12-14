package init.mg.app.payload.app

import com.fasterxml.jackson.annotation.JsonProperty


class Info {

    @JsonProperty("app_name")
    var appName : String? = null


    @JsonProperty("app_id")
    var appId : String? = null


}