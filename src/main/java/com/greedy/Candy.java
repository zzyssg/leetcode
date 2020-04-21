package com.greedy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 */
public class Candy {
    public int candy(int[] ratings) {
        int res = 0;
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        //遍历两遍
        for(int i = 1;i < nums.length;i++){
            if(ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1;
        }
        for(int i = nums.length - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1])
                nums[i] = Math.max(nums[i + 1] + 1,nums[i]);
        }
        for(int num : nums){
            res += num;
        }
        return res;

    }
}
