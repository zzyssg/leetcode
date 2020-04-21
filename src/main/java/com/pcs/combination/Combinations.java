package com.pcs.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n < k || k == 0) return res;
        help(n, 1, k, new LinkedList<Integer>(), res);
        return res;
    }

    private void help(int n, int index, int k, LinkedList<Integer> integers, List<List<Integer>> res) {
        if (integers.size() == k) {
            res.add(new LinkedList<>(integers));
            return;
        }
        //第一次添加时，可以遍历1-n；
        //下一次添加时，从下一个数开始
        for (int i = index; i <= n; i++) {
            integers.add(i);
            help(n, i + 1, k, integers, res);
            integers.removeLast();
        }
    }
}
