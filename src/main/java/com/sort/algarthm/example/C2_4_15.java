package com.sort.algarthm.example;

/**
 * 检测pq是否是面向最小元素的堆
 * @param <T>
 */
public class C2_4_15<T extends Comparable> {

    //仅需检查所有的父节点
    // 以0位置为第一个元素，则父节点为[(index+1)/2]
    // 以1位置为第一个元素，父节点为[index/2]
    public boolean isMinHeap(T[] pq) {
        for (int i = 0; i <= pq.length / 2; i++) {
            if (less(pq, i, 2 * i + 1) || less(pq, i, 2 * i + 2)) {
                return false;
            }
        }

        return true;
    }

    private boolean less(T[] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

}
