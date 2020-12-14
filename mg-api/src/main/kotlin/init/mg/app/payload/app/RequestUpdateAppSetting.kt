package init.mg.app.payload.app

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import init.mg.app.payload.enum.MobileOs
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
class RequestUpdateAppSetting {
        @NotEmpty
        @get:NotNull
         var os : MobileOs? = null;

        @get:NotNull
        lateinit var platformDetail : PlatformDetail;


}