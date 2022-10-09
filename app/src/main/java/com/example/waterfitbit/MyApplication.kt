package com.example.waterfitbit

import android.app.Application

class MyApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}