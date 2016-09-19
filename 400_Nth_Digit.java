public class Solution {
	public int findNthDigit(int n) {
		int bit = 1;
		long len = 0;
		while (true) {
			long iter = (long) (Math.pow(10, bit) - Math.pow(10, bit - 1))
					* bit;
			if (len + iter >= n)
				break;
			len += iter;
			bit++;
		}
		int left = (int) (n - len);
		// 定位的时候需要注意取余为0的情况；
		int index = left % bit == 0 ? left / bit - 1 : left / bit;
		int num = (int) Math.pow(10, bit - 1) + index;
		int bitIndex = left % bit == 0 ? bit - 1 : left % bit - 1;
		return String.valueOf(num).charAt(bitIndex) - '0';
	}
	public static void main(String[] args) {
		int n = 47854946;
		System.out.println(new Solution().findNthDigit(n));
	}
}
