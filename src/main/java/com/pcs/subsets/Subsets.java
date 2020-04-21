package com.pcs.subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        help(nums,0,new LinkedList<Integer>(),res);
        return res;
    }

    private void help(int[] nums,int index,LinkedList<Integer> integers, List<List<Integer>> res) {
        res.add(new LinkedList<>(integers));
        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            help(nums,i + 1,integers,res);
            integers.removeLast();
        }
    }
}
