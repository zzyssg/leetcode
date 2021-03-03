package com.sort.algarthm.pq;

import java.util.Scanner;

public class MaxPQ<Key extends Comparable> {
    private Key[] pq;
    private int N;

    public MaxPQ(int n) {
        pq = (Key[]) new Comparable[n + 1];
    }

    //新增数据
    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    //上游
    private void swim(int k) {
        while (k > 1 && less(pq, k / 2, k)) {
            ex(pq, k / 2, k);
            k = k / 2;
        }

    }

    private void ex(Key[] pq, int s, int k) {
        Key tem = pq[s];
        pq[s] = pq[k];
        pq[k] = tem;
    }

    private boolean less(Key[] pq, int s, int k) {
        return pq[s].compareTo(pq[k]) < 0;
    }

    public Key deleteMax() {
        Key max = pq[1];
        ex(pq, 1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int s = 2 * k;
            if (s < N && less(pq, s, s + 1)) {
                s++;
            }
            if (!less(pq, s, k)) {
                break;
            }
            ex(pq, s, k);
            k = s;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
//        System.out.println(ss.length);
//        System.out.println(ss.toString());
//        System.out.println(">>>>>>>>>>>");
//        for (int i = 0; i < ss.length; i++) {
//            System.out.print(ss[i] + " ");
//        }
//        System.out.println();
//        System.out.println(">>>>>>>>>>>");
        MaxPQ maxPQ1 = new MaxPQ<Character>(ss.length + 2);
        for (int i = 0; i < ss.length; i++) {
            Character c = ss[i].toCharArray()[0];
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                maxPQ1.insert(c);
            } else if (c == '*'){
                Character maxS = (Character) maxPQ1.deleteMax();
                System.out.print(maxS + " ");
            }
        }
        System.out.println();
    }

}
