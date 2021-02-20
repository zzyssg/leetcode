package com.sort.algarthm;

public class Merge extends Base{
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high - low) / 2 + low;
        sort(a,low,mid);
        sort(a,mid + 1,high);
        System.out.println(low + " " + mid + " " + high);
        merge(a,low,mid,high);
        System.out.println();

    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        //复制
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //归并
        for (int k = low; k <= high;k++) {
            //左边数据用完
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                //右边数据用完
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    public static void main(String[] args) {
        Integer[] ins = {6, 4, 3, 2, 1,34,56,2,45,57,121,2,3,4,5,6,7,8,9};
        Merge.sort(ins);
        Merge.show(ins);
    }

}
