package com.sort.algarthm;

public class InsectionWithSentenel extends Base{

    public static void sort(Comparable[] a){
        //找到哨兵元素
        int N = a.length;
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (less(a[i],a[min])) {
                min = i;
            }
        }
        //设置哨兵
        exch(a, 0, min);
        //插入排序
        for (int i = 2; i < N; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ins = {6, 5, 4, 3, 2, 1};
        InsectionWithSentenel.sort(ins);
        InsectionWithSentenel.show(ins);

    }

}
