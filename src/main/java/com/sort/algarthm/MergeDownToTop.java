package com.sort.algarthm;


public class MergeDownToTop extends Base{
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                System.out.println(lo + " " + (lo + sz - 1) + " " +  Math.min(lo + sz + sz - 1,N -1));
                merge(a,lo,lo + sz - 1,Math.min(lo + sz + sz - 1,N -1));
                System.out.println();
            }
        }

    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
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
        MergeDownToTop.sort(ins);
        MergeDownToTop.show(ins);
    }

}
