package com.sort.algarthm.pq;

import java.util.Random;

/**
 * 维持有序数组
 * 每次添加时，将末尾数字和前面的数组比较，最开始的为最小的，最后的为最大的；添加时调整顺序，删除时置空最后一位并减一
 * @param <T>
 */
public class OrderedArrayPQ<T extends Comparable> extends PQBase<T> {
    public OrderedArrayPQ(int maxSize, String typeClass) {
        super(maxSize, typeClass);
    }

    @Override
    public T deleteMax() {
        T max = pq[N];
        pq[N--] = null;
        return max;
    }

    @Override
    public void insert(T t) {
        //添加时，遍历-直到找到比自己小的位置
        N++;
        int n = N - 1;
        while (n > 0 && t.compareTo(pq[n]) < 0) {
            pq[n + 1] = pq[n];
            n--;
        }
        pq[n + 1] = t;
    }

    public static void main(String[] args) {
        OrderedArrayPQ<Integer> upq = new OrderedArrayPQ(30, Integer.class.getTypeName());
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int num = random.nextInt(20) + 1;
            upq.insert(num);
        }
        for (int i = 1; i <= upq.N; i++) {

            System.out.print(upq.pq[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(upq.deleteMax() + " ");
        }
        System.out.println();
    }
}
