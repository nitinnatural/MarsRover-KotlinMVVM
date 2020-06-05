package com.ni3x.marsrover.model

import java.util.ArrayList
import java.util.HashMap

class Dataset {

    var photos: List<Photo> = ArrayList()
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}