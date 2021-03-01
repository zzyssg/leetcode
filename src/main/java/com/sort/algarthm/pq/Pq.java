package com.sort.algarthm.pq;

import com.sort.SortUtils.SortUtils;
import com.sort.algarthm.MergeOfNature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pq {

    public static void sort(Comparable[] a) {

        //heapify
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        //排序
        while (N > 1) {
            ex(a, 1, N--);
            sink(a, 1, N);
        }


    }

    private static void sink(Comparable[] a, int k, int N) {

        while (2 * k <= N) {
            int s = 2 * k;
            if (s < N && less(a, s, s + 1)) {
                s++;
            }
            if (!less(a, k, s)) {
                break;
            }
            ex(a, k, s);
            k = s;
        }
    }

    private static boolean less(Comparable[] a, int k, int s) {
        k--;
        s--;
        return a[k].compareTo(s) < 0;
    }

    private static void ex(Comparable[] a, int i, int j) {
        i--;
        j--;
        Comparable tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public static void main(String[] args) {
//        Integer[] ins = {12, 24, 47, 45, 23, 68, 9, 24, 42, 27, 22};
//        PQSort.sort(ins);
//        for (Integer num : ins) {
//            System.out.print(num + " ");
//        }

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
            Pq.show(ins);
            Pq.sort(ins);
            if (!SortUtils.isSorted(ins)) {
                System.out.println(SortUtils.isSorted(ins));
            }
            Pq.show(ins);
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
