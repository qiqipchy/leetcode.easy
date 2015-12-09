package com.leetcode.twentyone;

public class Solution {
	public int reverseBits(int n) {
		int[] buf = new int[32];
		int[] mask = new int[32];
		int res = 0;

		// 注意巧妙的是使用了掩码，掩码是要哪一位，哪一位就是1；
		for (int i = 31; i >= 0; i--)
			mask[i] = 1 << i;

		for (int i = 31; i >= 0; i--)
			buf[i] = (n & mask[i]) == 0 ? 0 : 1;

		for (int i = 0; i < 32; i++)
			res = res * 2 + buf[i];

		return res;
	}

	public static void main(String[] args) {
		int n = 43261596;
		new Solution().reverseBits(n);
	}
}
