package com.sort;

import com.sortutils.GenerateRandomArray;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyMain {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] nums = GenerateRandomArray.getArray(10, 100);
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
//        Sort bubbleSort = new BubbleSort();
//        Sort sort = new QuickSort();
//        Sort sort = new InsertSort();
//        Sort sort = new ShellSort();
//        Sort sort = new ChooseSort();
//        Sort sort = new HeapSort();
//        Sort sort = new MergeSort();
//        sort.sort(nums);
        sortNums(nums);
        System.out.println();
        for (int i = 0; i < 10; i++) {
//            if (nums[i] > nums[i + 1]) {
//                System.out.println(false);
//            }
            System.out.print(nums[i] + " ");
        }
        System.out.println("_____________");



    }

    private static void sortNums(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int i, int j) {
        if(i >= j) return;
        int p = partation(nums, i, j);
        quickSort(nums, i, p - 1);
        quickSort(nums, p + 1, j);

    }

    private static int partation(int[] nums, int start, int end) {
        int i = start - 1, j = end;
        int base = nums[end];
        while (true) {
            while(--j >= start && nums[j] < base);
            while (++i <= end && nums[i] > base) ;
            if(i >= j) break;
            int tem1 = nums[i];
            nums[i] = nums[j];
            nums[j] = tem1;
        }
        int tem2 = nums[end];
        nums[end] = nums[i];
        nums[i] = tem2;
        return i;
    }
}
