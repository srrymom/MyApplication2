package com.example.myapplication;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MyCustomApplication extends Application {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey("6d4f46d0-123a-47c0-b6f1-e082e11a9472");
    }
}