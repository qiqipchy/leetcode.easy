package com.leetcode.twentyone;

public class Solution {

	public int compareVersion(String version1, String version2) {

		// 注意点号的分割方式写法
		// 注意1.2.0.0和1.2是相同的；
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int[] stoi1 = new int[v1.length];
		int[] stoi2 = new int[v2.length];

		// System.out.println(Arrays.toString(v1));
		// System.out.println(Arrays.toString(v2));

		for (int i = 0; i < v1.length; i++)
			stoi1[i] = Integer.parseInt(v1[i]);
		for (int i = 0; i < v2.length; i++)
			stoi2[i] = Integer.parseInt(v2[i]);
		// System.out.println(Arrays.toString(stoi1));
		// System.out.println(Arrays.toString(stoi2));

		int i;
		for (i = 0; i < stoi1.length && i < stoi2.length; i++) {
			if (stoi1[i] > stoi2[i])
				return 1;
			if (stoi1[i] < stoi2[i])
				return -1;
		}
		if (i == stoi1.length && i == stoi2.length)
			return 0;
		if (i != stoi1.length) {
			while (i < stoi1.length) {
				if (stoi1[i++] != 0)
					return 1;
			}
			return 0;
		} else if (i != stoi2.length) {
			while (i < stoi2.length) {
				if (stoi2[i++] != 0)
					return -1;
			}
			return 0;
		}
		return 0;

	}

	public static void main(String[] args) {
		String version1 = "1.2.0.0";
		String version2 = "1.2";
		System.out.println(new Solution().compareVersion(version1, version2));
	}
}
