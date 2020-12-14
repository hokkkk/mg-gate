package init.mg.app.payload.app

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import init.mg.app.payload.enum.MobileOs
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RequestUpdateAppSetting (

         var os : MobileOs ,

         var platformDetail : PlatformDetail


)