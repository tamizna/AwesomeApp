package com.example.awesomeapp

import android.app.Application

class AwesomeApplication : Application() {

    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}