
public class Solution {
	// 只要有一对2,5就会有一个0，就是找2,5的对数
	// 2肯定比5多，所以就是求5的个数
	// 求5的个数的方法；
	public int trailingZeroes(int n) {
		if (n < 1)
			return 0;
		int c = 0;
		// 第一遍的循环是由多少个5；
		// 第二遍的循环是有多少个25
		// ………………………………………………；
		while (n / 5 != 0) {
			n /= 5;
			c += n;
		}
		return c;
	}

	public static void main(String[] args) {
		int n = 55;
		System.out.println(new Solution().trailingZeroes(n));
	}
}
