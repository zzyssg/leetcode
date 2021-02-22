package com.sort.algarthm.quicksort;

import com.sort.algarthm.Base;

public class QuickSort extends Base {

    public static void sort(Comparable[] a){

        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a,int low,int high){
        if (low >= high) {
            return;
        }
        int N = a.length;
        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a,p + 1,high);

    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            //有边界检查
            while (i <= high && less(a[++i], v)) ;
            while (j >= low && less(v, a[--j]));
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a,low,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] ins = {84, 81, 16, 76, 5, 11, 46, 84, 75, 91};
        QuickSort.sort(ins);
        QuickSort.show(ins);
    }


}
