package com.sort;

public class ChooseSort extends Sort{
    @Override
    void sort(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            int k = i;
            for(int j = i + 1;j < nums.length;j++){
                //不稳定 2 4453，会将第一个4与3交换，造成不稳定
                if(nums[j] < nums[k]){
                    k = j;
                }
            }
            swap(nums, i, k);
        }
    }
}
