package com.leetcode.twentyone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int lengthOfLastWord(String s) {
		String[] words = s.split(" ");
		if (words.length == 0)
			return 0;
		else
			return words[words.length - 1].length();
	}

	public static void main(String[] args) {
		String s = "hello world";
		System.out.println(new Solution().lengthOfLastWord(s));
	}
}
