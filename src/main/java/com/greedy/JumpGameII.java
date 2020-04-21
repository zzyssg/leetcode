package com.greedy;

/**
 * 45. 跳跃游戏 II
 *
     给定一个非负整数数组，你最初位于数组的第一个位置。
     数组中的每个元素代表你在该位置可以跳跃的最大长度。
     你的目标是使用最少的跳跃次数到达数组的最后一个位置。

     说明:
     假设你总是可以到达数组的最后一个位置。

     //贪心，贪的是i + nums[i]，使得 end尽可能远
 *
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int count = 0;
        int end = 0;
        int maxIndex = 0;
        for(int i = 0;i < nums.length - 1;i++){
            maxIndex = Math.max(maxIndex, i + nums[i]);
            //到达end时跳
            if (i == end){
                count++;
                //更新end
                end = maxIndex;
            }
        }
        return count;
    }
}
