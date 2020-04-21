package com.greedy;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置(length - 1)。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int start = 0,end = 0;
        while(start <= end && end < nums.length - 1){
            //能走的最远的地方
            end = Math.max(end,start + nums[start]);
            start++;
        }
        return end >= nums.length - 1;
    }
}
