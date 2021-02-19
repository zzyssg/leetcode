package com.sort.algarthm;

public class InsectionWithoutEx extends Base{
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //定位需要移动的s和e  s = index a[index] < a[i],index + 1   e = i
            int sta = i - 1;
            while (sta >= 0 && less(a[i],a[sta])){
                sta--;
            }
            Comparable tem = a[i];
            for (int k = i - 1; k > sta; k--) {
                a[k + 1] = a[k];
            }
            a[sta + 1] = tem;
        }
    }

    public static void sort2(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable tem = a[i];
            int j;
            //注意tem 比前面小的时候才会交换
            for (j = i; j > 0 && less(tem, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = tem;
        }

    }

    public static void main(String[] args) {
        Integer[] ins = {8, 6, 5, 4, 3, 2, 1};
        InsectionWithoutEx.sort2(ins);
        InsectionWithoutEx.show(ins);
    }
}
