package com.sort;

public class MergeSort extends Sort {
    int[] help;
    @Override
    void sort(int[] nums) {
        help = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = (j - i) / 2 + i;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        merge(nums, i, mid, j);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            help[i] = nums[i];
        }
        int k = start, i = start, j = mid + 1;
        while (k <= end) {
            if (i > mid) {
                nums[k++] = help[j++];
            } else if (j >  end) {
                nums[k++] = help[i++];
            } else if (help[i] < help[j]) {
                nums[k++] = help[i++];
            } else {
                nums[k++] = help[j++];
            }
        }

    }

}
