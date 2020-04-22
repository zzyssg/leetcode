package com.banarysearch;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 临界值： 8  ——> 2 3 ，mid = 2，则 l = 2 + 1 = 3,h = 3   之后： h = mid - 1 = 2
 */
public class SqrtX {
    public int mySqrt(int x) {
        if(x <= 1) return x < 1 ? 0 : 1;
        int l = 1, h = x;
        //等于
        while (l <= h) {
            int mid = (h - l) / 2 + l;
            int tem = x / mid;
            if (tem == mid) {
                return tem;
            } else if (mid < tem) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }
}
