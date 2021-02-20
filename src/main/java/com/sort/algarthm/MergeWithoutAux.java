package com.sort.algarthm;

public class MergeWithoutAux extends Base {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(aux, a, 0, N - 1);

    }

    private static void sort(Comparable[] aux, Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high - low) / 2 + low;
        sort(aux, a, low, mid);
        sort(aux, a, mid + 1, high);
        //加快数组排序速度
        if (high - low < 5) {
            insertion( a, low, high);
        } else {
            merge(aux, a, low, mid, high);
        }


    }

    private static void insertion(Comparable[] a, int low, int high) {

        //哨兵sentinel
        for (int k = low + 1; k <= high; k++) {
            Comparable tem = a[k];
            int p;
            //a[p] --> tem
            for (p = k; p > 0 && less(tem, a[p - 1]); p--) {
                //不交换
                a[p] = a[p - 1];
            }
            a[p] = tem;
        }
    }

    private static void merge(Comparable[] aux, Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        //注意在此处给aux赋值，涉及范围为 low -- high
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (j > high) {
                a[k] = aux[i++];
            } else if (i > mid) {
                a[k] = aux[j++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ins = {1, 1, 1, 1, 1, 3, 4, 6, 7, 8, 9, 56, 34, 34, 23, 6, 68, 67, 46, 3};
        MergeWithoutAux.sort(ins);
        MergeWithoutAux.show(ins);
    }

}
