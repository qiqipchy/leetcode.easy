import java.util.ArrayList;
import java.util.List;

public class Solution {
	int n;

	public boolean isHappy(int n) {
		List<Integer> list = new ArrayList<Integer>();
		this.n = n;
		while (true) {
			int sum = 0;
			for (; n > 0; n /= 10)
				sum = sum + (n % 10) * (n % 10);
			if (sum == 1)
				return true;
			if (list.contains(sum))
				return false;
			list.add(sum);
			n = sum;
			// System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		int n = 199999999;
		System.out.println(new Solution().isHappy(n));
	}
}
