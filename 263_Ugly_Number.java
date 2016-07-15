public class Solution {
	// 其实题目很简单的，看本质嘛
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		// 全部化为奇数；
		while (num % 2 == 0)
			num /= 2;
		if (num == 1)
			return true;
		// 这里都是奇数，如果不能被3,5整除，那一定别的质数整除，最后都可以分解为质数的积
		// 这条还可以排除质数；
		if (!(num % 3 == 0 || num % 5 == 0))
			return false;

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				if (!(i % 3 == 0 || i % 5 == 0))
					return false;
				if (!(num / i % 3 == 0 || num / i % 5 == 0))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int num = 21;
		boolean flag = new Solution().isUgly(num);
		System.out.println(flag);
	}
}
