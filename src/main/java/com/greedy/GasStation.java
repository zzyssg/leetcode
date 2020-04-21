package com.greedy;

/**
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //假如当前净胜油量小于0，则无法到达下一个
        //若最终的油量小于0，则无法完成一周
        //假如真的能成功——total > 0,则index即为cur >= 0的
        int cur = 0,total = 0;
        int index = 0;
        for(int i = 0;i < gas.length;i++){
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        return total>= 0 ? index : -1;
    }
}
