package com.designpattern;

/**
 * 简单工厂模式
 *
 * 抽象Product、Product类、工厂类、
 *
 */
abstract class Phone{
    public abstract void sing();
}

class MiPhone extends Phone {

    @Override
    public void sing() {
        System.out.println("xiaomi");
    }
}

class IPhone extends Phone {
    @Override
    public void sing(){
        System.out.println("Iphone");
    }
}

class PhoneFactory{
    public Phone make(String kind){
        if(kind.equalsIgnoreCase("xiaOmI")){
            return new MiPhone();
        }else if(kind.equalsIgnoreCase("iphOne")){
            return new IPhone();
        }
        return null;
    }
}

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        PhoneFactory pf = new PhoneFactory();
        Phone phone = pf.make("xiaoMI");
        phone.sing();

    }
}
