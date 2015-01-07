package com.example.vronin.testapp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vronin on 1/6/15.
 */

@Module(
        injects = {
                MainActivity.class
        }
)
public class MyModule {
    private final MyApplication application;

    public MyModule(MyApplication application) {
        this.application = application;
    }
}
