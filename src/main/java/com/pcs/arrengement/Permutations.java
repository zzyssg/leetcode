package com.pcs.arrengement;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回所有可能的全排列
 *
 * ——全排列在递归时不需要index
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null) return res;
//        Arrays.sort(nums); 没有重复数字
        boolean[] visited = new boolean[nums.length];
        bt(nums,visited,new LinkedList<Integer>(),res);
        return res;
    }

    private void bt(int[] nums, boolean[] visited,LinkedList<Integer> integers, List<List<Integer>> res) {
        if(integers.size() == nums.length){
            res.add(new LinkedList<>(integers));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            integers.add(nums[i]);
            bt(nums, visited, integers, res);
            visited[i] = false;
            integers.removeLast();
        }

    }
}
