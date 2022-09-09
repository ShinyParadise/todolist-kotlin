package com.example.toDoListKotlin.ui

import android.app.Application

class ToDoListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ToDoListApp
            private set
    }
}
