
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int cnt = 0;
		String s = Integer.toBinaryString(n);
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1')
				cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int n=Integer.MIN_VALUE;
		System.out.println(new Solution().hammingWeight(n));
	}
}
