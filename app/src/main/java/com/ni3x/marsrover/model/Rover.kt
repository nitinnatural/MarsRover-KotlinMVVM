package com.ni3x.marsrover.model

import java.util.ArrayList
import java.util.HashMap

class Rover {
    var id: Int? = null
    var name: String? = null
    val landingDate: String? = null
    val maxSol: Int? = null
    val maxDate: String? = null
    val totalPhotos: Int? = null

    var cameras: List<Camera_> = ArrayList()
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}