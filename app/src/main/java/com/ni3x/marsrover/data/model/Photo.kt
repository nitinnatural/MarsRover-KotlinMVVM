package com.ni3x.marsrover.data.model

import com.squareup.moshi.Json

data class Photo(val id: Int,
                 val sol: Int,
                 val camera: Camera,
                 @Json(name = "imgSrc") val imgSrcUrl: String,
                 val earthDate: String,
                 val rover: Rover)