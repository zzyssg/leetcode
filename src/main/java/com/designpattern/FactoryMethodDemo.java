package com.designpattern;

import jdk.nashorn.internal.ir.IfNode;

/**
 * 简单工厂模式
 *
 * 抽象目标类、具体目标类、抽象工厂类
 *
 *
 *
 */
//abstract class Phone{
//    public abstract void sing();
//}
//
//class MiPhone extends Phone {
//    @Override
//    public void sing() {
//        System.out.println("xiaomi");
//    }
//}
//
//class IPhone extends Phone {
//
//    @Override
//    public void sing() {
//        System.out.println("iphone");
//    }
//}

interface IFactory{
    public abstract Phone makePhone();
}

class MiFactory implements IFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}

class IPhoneFactory implements IFactory {

    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        IFactory miFactory = new MiFactory();
        IFactory iphoneFactory = new IPhoneFactory();
        Phone miPhone = miFactory.makePhone();
        Phone iPhone = iphoneFactory.makePhone();
        miPhone.sing();
        iPhone.sing();

    }
}
