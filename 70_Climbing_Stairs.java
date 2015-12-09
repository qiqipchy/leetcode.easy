package com.leetcode.twentyone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int nums;
	int m;
	int n;

	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return n;
		int[] nums = new int[n];
		nums[0] = 1;
		nums[1] = 2;
		for (int i = 2; i < n; i++) {
			// 其实其并不懂，是经验看出来的。。。。。
			// 最有一步有两个选择，一个是走一步，一个是走两步；
			nums[i] = nums[i - 2]  + nums[i - 1] ;
		}
		return nums[n - 1];
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().climbStairs(n));
	}
}
