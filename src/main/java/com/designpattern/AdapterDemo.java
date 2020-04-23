package com.designpattern;

/**
 * 适配器模式
 * ——连接两个接口
 *
 * 对象适配器
 *
 */
interface Boy {
    void act();
}
interface Mp4{
    void play();
}

class Sony implements Mp4 {
    @Override
    public void play(){
        System.out.println("~~~");
    }
}

class LiLei implements Boy {
    Mp4 mp4;
    public LiLei (Mp4 mp4){
        this.mp4 = mp4;
    }
    @Override
    public void act(){
        mp4.play();
    }
}
public class AdapterDemo{
    public static void main(String[] args) {
        Mp4 sony = new Sony();
        Boy LiLei = new LiLei(sony);
        LiLei.act();

    }
}
