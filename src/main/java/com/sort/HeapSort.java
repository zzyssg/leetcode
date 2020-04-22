package com.sort;

public class HeapSort extends Sort {
    @Override
    void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        for(int i = nums.length - 1;i >= 0;i--){
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private void heapify(int[] nums, int i, int j) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        while (left < j) {
            if (nums[left] > nums[i]) {
                largest = left;
            }
            if (right < j && nums[right] > nums[largest]) {
                largest = right;
            }
            if (largest == i) break;
            swap(nums, largest, i);
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;

        }

    }

    private void heapInsert(int[] nums, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (nums[i] > nums[parent]) {
                swap(nums, i, parent);
                i = parent;
            } else {
                break;
            }
        }

    }

}
