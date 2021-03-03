package com.sort.algarthm.pq;


import java.util.Random;

/**
 * 【无序数组】实现优先队列
 * 插入元素，删除最大元素
 * @param <T>
 */
public class UnorderedArrayPQ<T extends Comparable> extends PQBase<T> {
    T max;

    public UnorderedArrayPQ(int maxSize, String typeClass) {
        super(maxSize, typeClass);
    }

    @Override
    public T deleteMax() {
        int maxIndex = 1;
        for (int i = 2; i <= N; i++) {
            if (pq[maxIndex].compareTo(pq[i]) < 0) {
                maxIndex = i;
            }
        }
        max = pq[maxIndex];
        ex(pq, maxIndex, N);
        pq[N] = null;
        N--;
        return max;
    }

    private void ex(T[] pq, int i, int j) {
        T tem = pq[i];
        pq[i] = pq[j];
        pq[j] = tem;
    }

    @Override
    public void insert(T t) {
        pq[++N] = t;
    }

    public static void main(String[] args) {
        UnorderedArrayPQ<Integer> upq = new UnorderedArrayPQ(7, Integer.class.getTypeName());
        for (int i = 10; i > 5; i--) {
            Random random = new Random();
            int num = random.nextInt(20) + 1;
            upq.insert(num);
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(upq.deleteMax() + " ");
        }
        System.out.println();
    }
}
