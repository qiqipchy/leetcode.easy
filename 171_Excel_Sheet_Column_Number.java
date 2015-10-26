public class Solution {
	public int titleToNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			sum = sum * 26 + (ch - 'A' + 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		String s = "AB";
		System.out.println(new Solution().titleToNumber(s));
	}
}
