package com.sort.algarthm;

public class MergeOfNature extends Base {
    private static Comparable[] aux;
    //找到第一个比前一个数字小的位置j ---- i = j - 1
    //再找到第一个比前一个数字小的位置k ---- j = k - 1
    //merge(a,0,i,j)
    //更新i = j
    //继续找到j
    //merge(a,0,i,j)
    //直到i = right
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        int i = 0;
        while (i < N){
            //定位i
            int j = i + 1;
            while (j < N && less(a[j], a[j + 1])) {
                j++;
            }
            i = j - 1;
            //定位j
            int k = j + 1;
            while (k < N && less(a[k], a[k + 1])) {
                k++;
            }
            j = k - 1;
            //归并
            merge(a, 0, i, j);
            //更新i
            i = j;
        }

    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (j > high) {
                a[k] = aux[i++];
            } else if (i > mid) {
                a[k] = aux[j++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ins = {3, 4, 56, 7, 8, 9, 2, 1};
        MergeOfNature.sort(ins);
        MergeOfNature.show(ins);
    }

}
