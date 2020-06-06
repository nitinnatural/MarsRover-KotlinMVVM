package com.ni3x.marsrover.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cameras(

        val name: String,
        val full_name: String
): Parcelable