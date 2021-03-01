package com.sort.algarthm.pq;

import com.sort.SortUtils.SortUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PQSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N / 2; i >= 0; i--) {
            sink(a, i, N);
        }
        while (N > 0) {
            ex(a, 0, --N);
            sink(a, 0, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        //s——子
        while (2 * k + 1 < N) {
            int s = 2 * k + 1;
            if (s < N - 1 && less(a, s, s + 1)) {
                s++;
            }
            if (!less(a, k, s)) {
                break;
            }
            ex(a, k, s);
            k = s;
        }
    }

    private static boolean less(Comparable[] a, int s, int k) {
        return a[s].compareTo(a[k]) < 0;
    }

    private static void ex(Comparable[] a, int i, int j) {
        Comparable tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public static void main(String[] args) {
        int time = 50;
        int len = 10;
        Integer[] ins;
        for (int i = 0; i < time; i++) {
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            for (int j = 0; j < len; j++) {
                int num = random.nextInt(100) + 1;
                list.add(num);
            }
            ins = list.toArray(new Integer[]{});
            PQSort.show(ins);
            PQSort.sort(ins);
            if (!SortUtils.isSorted(ins)) {
                System.out.println(SortUtils.isSorted(ins));
            }
            PQSort.show(ins);
            System.out.println("--------------------");
        }

    }

    private static void show(Integer[] ins) {
        for (Integer num : ins) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
