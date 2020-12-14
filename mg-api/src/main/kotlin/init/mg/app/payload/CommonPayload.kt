package init.mg.app.payload

import init.mg.app.helper.ObjectUtil

open class CommonPayload {
    override fun toString(): String {
        return ObjectUtil.writeValueAsString(this)
    }
}