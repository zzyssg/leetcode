package com.sort;

import com.sortutils.GenerateRandomArray;

public class MyMain {
    public static void main(String[] args) {
        int[] nums = GenerateRandomArray.getArray(10, 100);
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
//        Sort bubbleSort = new BubbleSort();
//        Sort sort = new QuickSort();
//        Sort sort = new InsertSort();
        Sort sort = new ShellSort();
        sort.sort(nums);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
//        bubbleSort
    }
}
