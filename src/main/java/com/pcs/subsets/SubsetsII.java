package com.pcs.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 总结：
 * 1、若数字重复，需要排序并且在循环中去重。
 * 2、若为全排列，不需要在递归中加上index
 * 3、若为子集，则需要在递归汇总加上index，以备去重
 *
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0) return res;
        //数字重复
        Arrays.sort(nums);
        dp(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void dp(int[] nums, int index, LinkedList<Integer> integers, List<List<Integer>> res) {
        res.add(new LinkedList<>(integers));
        for(int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            integers.add(nums[i]);
            dp(nums, i + 1, integers, res);
            integers.removeLast();
        }
    }

}
