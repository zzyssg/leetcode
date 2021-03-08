package com.sort.algarthm.example;


public class C2_4_19<T extends Comparable> {
    private T[] pq;
    private int N = 0;

    public C2_4_19(int maxSize) {
        this.pq = (T[]) new Comparable[maxSize + 1];
    }

    public C2_4_19(Comparable[] a) {
        //err - int aLen = a.length;
        //err - this.N = aLen + 1;
        //N为元素的个数，顺便充当优先队列的下标
        this.N = a.length;
        //N + 1个
        this.pq = (T[]) new Comparable[N + 1];
        for (int i = 0; i < N; i++) {
            pq[i + 1] = (T) a[i];
        }
        for (int i = N / 2; i >= 1; i--) {
            sink(i);
        }


    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            ex(pq, k, j);
        }
    }

    private void ex(T[] pq, int k, int j) {
        T t = pq[k];
        pq[k] = pq[j];
        pq[j] = t;
    }

    private boolean less(T[] pq, int j, int i) {
        return pq[j].compareTo(pq[i]) < 0;
    }
}
