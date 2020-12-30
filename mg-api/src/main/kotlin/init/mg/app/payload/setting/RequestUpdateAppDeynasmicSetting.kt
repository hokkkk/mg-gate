package init.mg.app.payload.setting

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import init.mg.app.payload.enum.MobileOs

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RequestUpdateAppDeynasmicSetting (

         var os : MobileOs ,

        var hashMap : HashMap<String,Object>
)