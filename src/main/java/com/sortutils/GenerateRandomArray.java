package com.sortutils;

import java.util.Random;

public class GenerateRandomArray {

    public static int[] getArray(int n,int range){
        int[] nums = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0;i < n;i++){
            nums[i] = random.nextInt(range) + 1;
        }
        return nums;
    }
}
