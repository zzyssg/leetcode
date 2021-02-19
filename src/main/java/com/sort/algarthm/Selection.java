package com.sort.algarthm;

public class Selection extends Base {

    public static void sort(Comparable[] a){
        System.out.println("son...");
        //将a数组按照升序排列
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minInd])) {
                    minInd = j;
                }
            }
            //自身可以交换，一个元素最多可以交换N次
            exch(a,minInd,i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {new Integer(5), new Integer(6), new Integer(1), new Integer(3), new Integer(3)};
        Selection.sort(arr);
        Base.sort(arr);
        Selection.show(arr);
    }
}
