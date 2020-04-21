package com.sort;

abstract class Sort {
    abstract void sort(int[] nums) ;
    void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
