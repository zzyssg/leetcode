package com.banarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 */
public class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int index1 = getIndex(nums, target);
        int index2 = getIndex(nums, target + 1);
        if (index1 == nums.length || nums[index1] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{index1, index2 - 1};
    }

    private int getIndex(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = (h - l) / 2 + l;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
