package com.sort.algarthm.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无序数组实现的ArrayST
 *
 * @param <Key>
 * @param <Val>
 */
public class C_3_1_2<Key extends Comparable<Key>, Val> {
    private Key[] keys;
    private Val[] vals;
    private int N;

    public C_3_1_2(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Val[]) new Object[capacity];
    }

    //1、if key has existed
    //2.not existed
    public void put(Key key, Val val) {
        if (!contains(key)) {
            keys[N] = key;
            vals[N] = val;
        } else {
            int k = indexOf(key);
            vals[k] = val;
        }
        N++;
    }

    public Val get(Key key) {
        //查找到key的位置k
        int k = indexOf(key);
        return vals[k];
    }

    private int indexOf(Key key) {
        //遍历keys，一次比较key，相等时返回i
        for (int i = 0; i < N; i++) {
            //TODO 用哪种比较？
            if (key == keys[i]) {
                return i;
            }
        }
        return -1;
    }

    public void delete(Key key) {
        //找到位置 - 覆盖
        int k = indexOf(key);
        if (!contains(key)) {
            return;
        }
        //覆盖
        for (int i = k + 1; i < N; i++) {
            keys[i - 1] = keys[i];
            vals[i - 1] = vals[i];
        }
        //接触引用
        keys[N] = null;
        vals[N] = null;
        N--;

    }

    public boolean contains(Key key) {
        return indexOf(key) != -1;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //表中的键的集合
    public Iterable<Key> keys() {
        //Queue<Key> q = new Queue<>(); //书中此行用了自定义的Queue类，因此可以new
        Queue<Key> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(keys[i]);
        }
        return q;
    }

}
