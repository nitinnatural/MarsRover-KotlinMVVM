package com.ni3x.marsrover.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultSet(

        val photos: List<Photos>
): Parcelable