package com.example.vronin.testapp;

import javax.inject.Inject;

/**
 * Created by vronin on 1/6/15.
 */
public class Foo {
    @Inject
    Bar bar;

    public int getFoo() {
        return bar.getBar();
    }
}

