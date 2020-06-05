package com.ni3x.marsrover.model

import java.util.HashMap

class Camera {

    var id: Int? = null
    var name: String? = null
    val roverId: Int? = null
    val fullName: String? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}