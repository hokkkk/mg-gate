package init.mg.app.payload.project

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName


class Info {

    @JsonProperty("project_name")
    var projectName : String? = null


    @JsonProperty("project_id")
    var projectId : String? = null


}