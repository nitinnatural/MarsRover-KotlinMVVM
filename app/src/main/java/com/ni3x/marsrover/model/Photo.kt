package com.ni3x.marsrover.model

import java.util.HashMap

class Photo {

    var id: Int? = null
    var sol: Int? = null
    var camera: Camera? = null
    var imgSrc: String? = null
    var earthDate: String? = null
    var rover: Rover? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}