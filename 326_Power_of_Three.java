public class Solution {
	// 借鉴是否是2的阶乘的方法，将数字转换为2进制字符串，是power的只可能在其字符串中只能出现一个1；
	public boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		if (n % 3 != 0 || n < 0)
			return false;
		String threeString = Integer.toString(n, 3);
		System.out.println(threeString);
		int index1 = threeString.indexOf('1');
		int index2 = threeString.indexOf('2');
		if (index1 == -1 || index2 != -1)
			return false;
		int index11 = threeString.substring(index1 + 1).indexOf('1');
		// System.out.println(index11);
		if (index11 == -1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int n = 27;
		System.out.println(new Solution().isPowerOfThree(n));
	}
}
