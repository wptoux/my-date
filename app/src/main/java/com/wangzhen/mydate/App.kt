package com.wangzhen.mydate

import android.app.Application
import com.wangzhen.mydate.presentation.EventManager

class App : Application() {
    lateinit var eventManager: EventManager
        private set

    override fun onCreate() {
        super.onCreate()

        eventManager = EventManager(this as Application)


    }



}