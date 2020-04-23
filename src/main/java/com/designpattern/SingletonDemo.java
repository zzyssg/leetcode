package com.designpattern;

public class SingletonDemo {
    private static volatile SingletonDemo singleton;
    private SingletonDemo(){}

    private static SingletonDemo getInstance() {
        if (singleton == null) {
            synchronized (SingletonDemo.class) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }
}
