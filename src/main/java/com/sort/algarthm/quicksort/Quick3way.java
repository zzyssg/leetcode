package com.sort.algarthm.quicksort;

import com.sort.algarthm.Base;

public class Quick3way extends Base {

    public static void sort(Comparable[] a) {
        sort(a,0,a.length - 1);

    }

    private static void sort(Comparable[] a, int low, int high) {

        if (low >= high) {
            return;
        }
        int lt = low, i = low + 1, gt = high;
        Comparable v = a[low];
        while (i <= gt) {
            int com = a[i].compareTo(v);
            if (com < 0) {
                exch(a,lt++,i++);
            } else if (com > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }//此时，a[low..lt - 1] < v, a[gt + 1 .. high] > v

        //忽略了大量重复的元素 lt..gt
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }

    public static void main(String[] args) {
        Integer[] ins = {84, 81, 16, 76, 5, 11, 46, 84, 75, 91};
        Quick3way.sort(ins);
        Quick3way.show(ins);
    }

}
