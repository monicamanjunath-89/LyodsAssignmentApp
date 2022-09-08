package com.assignment.lloydsassignmentapp.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
public final class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}