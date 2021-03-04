package com.sort.algarthm.pq;

import java.util.Scanner;

/**
 * 最大堆 -- 实现优先队列
 * @param <T>
 */
public class MaxPQ<T extends Comparable> {
    private T[] pq;
    private int N = 0;

    public MaxPQ(int maxSize) {
        pq = (T[]) new Comparable[maxSize + 1];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //插入时构造堆
    public void insert(T t) {
        pq[++N] = t;
        //调整堆 pq[N]上升至能胜任的位置
        swim(N);
    }

    //上游
    private void swim(int k) {
        while (k > 1 && less(pq, k / 2, k)) {
            ex(pq, k / 2, k);
            k /= 2;
        }

    }

    private void ex(T[] pq, int i, int k) {
        T tem = pq[i];
        pq[i] = pq[k];
        pq[k] = tem;
    }

    private boolean less(T[] pq, int i, int k) {
        return pq[i].compareTo(pq[k]) < 0;
    }

    public T deleteMax() {
        T max = pq[1];
        ex(pq, 1, N--);

        //TODO 改为最小值
        pq[N + 1] = null;
        //调整堆 pq[1]下降至盖到的地方
        sink(1);
        return max;
    }

    //下沉
    private void sink(int k) {

        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            ex(pq, k, j);
            k = j;
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
