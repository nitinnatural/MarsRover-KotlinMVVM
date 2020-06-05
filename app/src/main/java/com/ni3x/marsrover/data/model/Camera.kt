package com.ni3x.marsrover.data.model

data class Camera(var id: Int,
                  var name: String,
                  val roverId: Int,
                  val fullName: String
)