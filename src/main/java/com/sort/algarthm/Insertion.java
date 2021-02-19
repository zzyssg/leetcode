package com.sort.algarthm;

public class Insertion extends Base {
    //按照升序排列
    public static void sort(Comparable[] a){
        int len = a.length;
        //i处左侧的元素已经有序
        for (int i = 1; i < len; i++) {
            //j的位置一直变动，直到less(a[j],a[j - 1])为false
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }
    }

    public static void main(String[] args) {
        Integer[] arr = {new Integer(41), new Integer(1), new Integer(2), new Integer(5), new Integer(3)};
        Insertion.sort(arr);
        Insertion.show(arr);
    }
}
