package com.sort;

/**稳定
 * 平均O(N^2)
 * 最差O(N^2)
 * 最好O(N^2)
 */
public class BubbleSort extends Sort{
    @Override
    void sort(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            for(int j = nums.length - 1;j > i;j--){
                if(nums[j] < nums[j - 1]) swap(nums, j, j - 1);
            }
        }
    }
}
