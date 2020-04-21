package com.pcs.arrengement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回不重复全排列
 *
 * ——全排列在递归时不需要index
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null) return res;
        //需要去重
        Arrays.sort(nums);
        boolean[] vi = new boolean[nums.length];
        help(nums,vi,new LinkedList<Integer>(),res);
        return res;
    }

    private void help(int[] nums, boolean[] vi,LinkedList<Integer> integers, List<List<Integer>> res) {
        if(integers.size() == nums.length) {
            res.add(new LinkedList<>(integers));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(vi[i] || i > 0 && nums[i] == nums[i - 1] && !vi[i - 1]) continue;
            vi[i] = true;
            integers.add(nums[i]);
            help(nums,vi,integers,res);
            integers.removeLast();
            vi[i] = false;
        }

    }

}
