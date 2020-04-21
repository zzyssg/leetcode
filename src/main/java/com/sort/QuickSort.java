package com.sort;

public class QuickSort extends Sort {
    @Override
    void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int i, int j) {
        if(i >= j) return;
        int p = partition(nums, i, j);
        quickSort(nums, i, p - 1);
        quickSort(nums, p + 1, j);

    }

    private int partition(int[] nums, int start, int end) {
        int i = start,j = end + 1;
        int base = nums[i];
        while (true) {
            while (++i < end && nums[i] < base) ;
            while (--j > start && nums[j] > base) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
}
