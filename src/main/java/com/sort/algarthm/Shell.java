package com.sort.algarthm;

public class Shell extends Base {

    //数组按照升序有序
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N / 3 ){
            h = h * 3 + 1;
        }
        while (h > 0) {
            //数组变为h有序
            for (int i = h; i < N; i += h) {
                for (int j = i; j > 0 && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
        show(a);
    }

    public static void main(String[] args) {
        Integer[] arr = {new Integer(7), new Integer(5), new Integer(1), new Integer(3), new Integer(12)};
        sort(arr);
        show(arr);
    }
}
