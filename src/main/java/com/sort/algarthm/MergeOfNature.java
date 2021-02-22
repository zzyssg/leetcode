package com.sort.algarthm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeOfNature extends Base {
    private static Comparable[] aux;

    //找到第一个比前一个数字小的位置j ---- i = j - 1
    //再找到第一个比前一个数字小的位置k ---- j = k - 1
    //merge(a,0,i,j)
    //更新i = j
    //继续找到j
    //merge(a,0,i,j)
    //直到i = right
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        int i = 0;
        int j = 1;
        while (j < N - 1) {
            //定位i
            while (j < N && !less(a[j], a[j - 1])) {
                j++;
            }
            i = j - 1;
            //定位j
            int k = j + 1;
            while (k < N && !less(a[k], a[k - 1])) {
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
//        Integer[] inss = {84, 81, 16, 76, 5, 11, 46, 84, 75, 91};
//        MergeOfNature.sort(inss);
//        MergeOfNature.show(inss);

        int time = 50;
        int len = 10;
        Integer[] ins;
        for (int i = 0; i < time; i++) {
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            for (int j = 0; j < len; j++) {
                int num = random.nextInt(100) + 1;
                list.add(num);
            }
            ins = list.toArray(new Integer[]{});
            MergeOfNature.show(ins);
            MergeOfNature.sort(ins);
            if (!MergeOfNature.isSorted(ins)) {
                System.out.println(MergeOfNature.isSorted(ins));
            }
            MergeOfNature.show(ins);
            System.out.println("--------------------");
        }
    }

}
