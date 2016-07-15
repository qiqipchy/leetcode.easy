public class Solution {
	// 两个数的加法是异或，进位是与；
	public int getSum(int a, int b) {
		int carry = a & b;
		a = a ^ b;
		while (carry != 0) {
			b = carry << 1;
			carry = a & b;
			a = a ^ b;
		}
		return a;
	}

	public static void main(String[] args) {
		int a = 1, b = 127, sum;
		sum = new Solution().getSum(a, b);
		System.out.println(sum);
	}
}
