package com.ni3x.marsrover.data.model

import java.util.HashMap

class Camera_ {

    var name: String? = null
    var fullName: String? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}