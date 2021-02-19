package com.sort.algarthm;

import java.util.Scanner;

public class SortNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numLine = scanner.nextLine();
        String[] numStrs = numLine.split(" ");
        Long[] nums = new Long[numStrs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(numStrs[i]);
            System.out.print(nums[i] + " ");
        }
        Shell.sort(nums);
        Shell.show(nums);


    }

}
