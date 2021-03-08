package com.sort.algarthm.pq;

import java.util.Scanner;

/**
 * 最大堆 -- 实现优先队列
 *
 * @param <T>
 */
public class MaxPQ<T extends Comparable> {
    private T[] pq;
    private int N = 0;

    private T min = null;

    public MaxPQ(int maxSize) {
        pq = (T[]) new Comparable[maxSize + 1];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //插入时构造堆
    public void insert(T t) {
        //更新最小值
        if (isEmpty()) {
            min = t;
        }else {
            min = min(min, t);
        }

        if (N == pq.length - 1) {
            resize(N * 2);
        }
        pq[++N] = t;
        //调整堆 pq[N]上升至能胜任的位置
        swim(N);
    }

    private T min(T min, T t) {
        boolean isMin = min.compareTo(t) < 0;
        return isMin ? min : t;
    }

    private void resize(int newSize) {
        T[] newPq = (T[]) new Comparable[newSize + 1];
        for (int i = 1; i <= N; i++) {
            newPq[i] = pq[i];
        }
        pq = newPq;

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
        //若为空，则将min置为null
        if (isEmpty()) {
            min = null;
        }
        //调整堆 pq[1]下降至该到的地方
        sink(1);
        return max;
    }

    //返回队列中的最小元素
    // 1.添加成员变量min
    // 2.insert时，更新min
    // 3.delete时，若删除后数组为null，则置为null；否则无需操作——因为为最小值，在二叉树的最后一层
    public T getMin() {
        return min;
    }

    //下沉
    private void sink(int k) {

        while (k * 2 <= N) {
            int j = k * 2;
            //首先判断左子节点是不是最后一个节点 ；若不是，则取左右子节点中的最大值
            // 去掉 j < N.意味着 所有情况下(是指？  j < N 和 j = N时)的值均为 less()的值
            // j < N时，条件等价于 less
            // j = N时， j < N为假， 则需要less一定为假 —— N始终不小于N + 1处的值 —— N + 1处的值为最小
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

    //无需交换的sink
    private void sinkWithoutEx(int k) {
        //保留pq[k]
        T t = pq[k];
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            pq[k] = pq[j];
            k = j;
        }
        pq[k] = t;
    }

    //无需交换的swim
    private void swimWithoutEx(int k) {
        T t = pq[k];
        while (k > 1 && less(pq, k / 2, k)) {
            pq[k] = pq[k / 2];
            k /= 2;
        }
        pq[k] = t;
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
            } else if (c == '*') {
                Character maxS = (Character) maxPQ1.deleteMax();
                System.out.print(maxS + " ");
            }
        }
        System.out.println();
    }

}
