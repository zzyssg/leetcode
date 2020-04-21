package com.sort;

abstract class Sort {
    abstract void sort(int[] nums) ;
    void swap(int[] nums,int num1,int num2){
        int tem = num1;
        num1 = num2;
        num2 = tem;
    }

}
