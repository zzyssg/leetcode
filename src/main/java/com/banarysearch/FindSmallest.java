package com.banarysearch;

/**
 *744. 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 在比较时，数组里字母的是循环有序的。举个例子：
 * 如果目标字母 target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * 如果目标字母 target = 'n' 并且有序数组为 letters = ['m', 'z', 'c', 'f', 'j'] ，则答案返回 'z' 。
 *
 */
public class FindSmallest {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            //找到大于target的 [第一个数]
            if (letters[mid] > target) {
                //mid 满足排除大于mid的范围
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j == letters.length ? letters[0] : letters[j];
    }
}
