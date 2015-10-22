public class Solution {
	// 埃氏筛,使用n的空间复杂度来换取时间复杂度；
	public int countPrimes(int n) {

		int cnt = 0;
		boolean[] flag = new boolean[n + 1];
		for (int i = 2; i < n; i++) {
			if (!flag[i]) {
				// 也不同判断isPrime(),因为被标记之后，留下的肯定是素数；
				// if (isPrime(i)) {
				// 不使用这样的方法，太慢了；
				// for (int k = i + 1; k <= n; k++) {
				// if (!flag[k] && k % i == 0)
				// flag[k] = true;
				// }
				for (int k = i + i; k < n; k += i) {
					flag[k] = true;
				}
			}
			if (i * i > n)
				break;
		}
		for (int i = 2; i < n; i++)
			if (!flag[i])
				cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		int n = 1500000;
		System.out.println(new Solution().countPrimes(n));
	}
}
