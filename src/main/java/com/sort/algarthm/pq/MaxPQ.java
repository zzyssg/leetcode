package com.sort.algarthm.pq;

public class MaxPQ<Key extends Comparable> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int size) {
        pq = (Key[]) new Comparable[size + 1];
    }

    public int getSize() {
        return N;
    }

    //insert
    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
        printPQ();
        if (N >= 0.75 * pq.length) {
            resizePQ(pq.length * 2);

        }

    }

    //扩容至2倍
    private void resizePQ(int newSize) {
        Key[] newPQ = (Key[]) new Comparable[newSize];
        for (int i = 0; i < pq.length; i++) {
            newPQ[i] = pq[i];
        }
        pq = newPQ;
    }

    private void printPQ() {
        for (int i = 1; i <= N; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    //底层元素上游
    private void swim(int k) {
        //比父元素大
        while (k > 1 && less(k / 2, k)) {
            ex(k / 2, k);
            k = k / 2;
        }
    }

    private void ex(int p, int k) {
        Key tem = pq[p];
        pq[p] = pq[k];
        pq[k] = tem;
    }

    private boolean less(int p, int k) {
        return pq[p].compareTo(pq[k]) < 0;
    }

    //delete
    public Key deleteMax() {
        Key max = pq[1];
        ex(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    //小元素下沉
    private void sink(int k) {
        int s = k * 2;
        while (s <= N) {
            if (s < N && less(s, s + 1)) {
                s = s + 1;
            }
            //TODO
            if (!less(k, s)) {
                break;
            }
            ex(k, s);
            k = s;
        }
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(10);
        for (int i = 0; i < 8; i++) {
            maxPQ.insert(new Integer(i));
        }
    }

}
