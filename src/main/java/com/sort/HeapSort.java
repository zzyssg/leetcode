package com.sort;

public class HeapSort extends Sort {


    @Override
    void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //大根堆
            heapInsert(nums, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            //调整
            heapify(nums, 0, i);
        }
    }

    private void heapify(int[] nums, int i, int j) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        while (left < j) {
            if (nums[i] < nums[left]) {
                largest = left;
            }
            if (right < j && nums[largest] < nums[right]) {
                largest = right;
            }
            if (i == largest) break;
            swap(nums, largest, i);
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }

    }

    private void heapInsert(int[] nums, int i) {
        int parent;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (nums[parent] < nums[i]) {
                swap(nums, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }
}
