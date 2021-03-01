package com.sort.SortUtils;

public class SortUtils {
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a, i , i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }
}
