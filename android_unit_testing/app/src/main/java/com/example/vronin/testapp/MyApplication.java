package com.example.vronin.testapp;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by vronin on 1/6/15.
 */
public class MyApplication extends Application {
    private ObjectGraph applicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new MyModule(this)
        );
    }
    public void inject(Object object) {
        applicationGraph.inject(object);
    }
}
