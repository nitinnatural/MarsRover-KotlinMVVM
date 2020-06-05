package com.ni3x.marsrover.common

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun stringToDate(dateStr: String?): Date {
        var date = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        try {
            date = sdf.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }

    fun readableDate(date: Date?): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return sdf.format(date)
    }
}