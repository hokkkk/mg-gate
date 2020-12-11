package init.mg.app.payload.enum

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue


enum class MobileOs {
    AOS("AOS"),
    ANDROID("AOS"),
    IOS("IOS"),
    ;

    var value : String

    constructor(value : String ){
        this.value = value;
    }

//    @JsonValue
//    fun getValue(): String
//    {
//        return this.value
//    }

    companion object {
        @JsonCreator
        public fun fromValue( value : String) : MobileOs?
        {
            for ( my : MobileOs in MobileOs.values())
                if (my.value.equals(value))
                    return my

             return null
        }
    }
}