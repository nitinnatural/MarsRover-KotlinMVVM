package com.ni3x.marsrover.data.model

import java.util.ArrayList

class Rover(
        var id: Int,
        var name: String,
        val landingDate: String,
        val maxSol: Int,
        val maxDate: String,
        val totalPhotos: Int,
        var cameras: List<Camera_> = ArrayList()
)