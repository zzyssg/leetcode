package com.sort.algarthm.pq;

import java.lang.reflect.Array;

public class PQBase<T> {
    protected T[] pq;
    protected int N;

    public PQBase(int maxSize,String typeClass) {
        try {
            Class<?> tType = Class.forName(typeClass);
            pq = (T[]) Array.newInstance(tType, maxSize + 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public T[] getPq() {
        return pq;
    }

    public T deleteMax() {
        return pq[1];
    }

    public void insert(T t) {

    }

}
