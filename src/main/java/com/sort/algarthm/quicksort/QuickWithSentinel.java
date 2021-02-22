package com.sort.algarthm.quicksort;

import com.sort.algarthm.Base;

public class QuickWithSentinel extends Base {

    public static void sort(Comparable[] a){

        exch(a, maxIdx(a), a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a, p + 1, high);

    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            //去掉右边边界检查 -- less(a[high],v)必为假
            while (less(a[++i], v));
            //去左 -- less(v,a[low])必为假
            while (less(v, a[--j])) ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    private static int maxIdx(Comparable[] a) {

        int res = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[res])) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] ins = {23, 2, 3, 4, 3, 7, 8, 99, 5, 3, 2, 1, 45,};
        QuickWithSentinel.sort(ins);
        QuickWithSentinel.show(ins);
    }


}
