package com.example.awesomeapp.utils

import com.example.awesomeapp.AwesomeApplication

object ResourceUtil {

    fun getString(resourceId : Int) : String {
        return AwesomeApplication.application.resources.getString(resourceId)
    }

    fun getStringArray(resourceId : Int) : Array<String> {
        return AwesomeApplication.application.resources.getStringArray(resourceId)
    }
}