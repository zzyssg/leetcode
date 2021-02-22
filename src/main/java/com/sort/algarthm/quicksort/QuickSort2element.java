package com.sort.algarthm.quicksort;

import com.sort.algarthm.Base;

public class QuickSort2element extends Base {

    public static void sort(Comparable[] a){

        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int low, int high) {

        if (low >= high) {
            return;
        }
        //取最小的元素作为哨兵
        int mInx = getMax(a, low, high);
        int i = low, j = high + 1;
        while (true) {
            while (less(a[++i], a[mInx])) {
                if (i == high) {
                    break;
                }
            }
            while (!less(a[--j],a[mInx])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a,mInx,j);
    }

    private static int getMax(Comparable[] a, int low, int high) {
        if (low >= high) {
            return low;
        }
        int max = low;
        for (int i = low; i <= high; i++) {
            if (less(a[max], a[i])) {
                max = i;
                break;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Integer[] ins = {2,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2};
        QuickSort2element.sort(ins);
        QuickSort2element.show(ins);

    }

}
