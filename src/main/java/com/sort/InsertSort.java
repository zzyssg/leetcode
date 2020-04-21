package com.sort;

public class InsertSort extends Sort {
    @Override
    void sort(int[] nums) {
        for(int i = 1;i < nums.length;i++){
            for(int j = i;j > 0 && nums[j] < nums[j - 1];j--){
                swap(nums, j, j - 1);
            }
        }

    }
}
