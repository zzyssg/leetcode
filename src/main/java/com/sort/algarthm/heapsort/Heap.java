package com.sort.algarthm.heapsort;

/**
 * 堆排序 = 堆得构建 + 排序
 * @param <T>
 */
public class Heap<T extends Comparable>{
    private Comparable[] pq;
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 构建堆 + （循环） 交换最大+重构堆
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        //构建堆
        for (int i = N / 2; i >= 1; i--) {
            sink(a,i,N);
        }
        //交换堆中max + 构建堆
        while (N > 1) {
            ex(a, 1, N--);
            sink(a,1,N);
        }

    }

    private static void ex(Comparable[] a, int i, int j) {
        Comparable tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    private static void sink(Comparable[] a,int k,int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, j, k)) {
                break;
            }
            ex(a, j, k);
        }
    }

    private static boolean less(Comparable[] a, int j, int i) {
        return a[j].compareTo(a[i]) < 0;
    }

}
