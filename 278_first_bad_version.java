import java.util.Arrays;

/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */
class VersionControl {
	boolean isBadVersion(int version) {
		if (version >= 2)
			return true;
		return false;
	}
}

public class Solution extends VersionControl {
	public int firstBadVersion(int n) {

		int left = 1, right = n;
		// 注意mid的写法，这样不会整数溢出；
		int mid = left + (right - left) / 2;

		// 注意二分法的正确写法
		// 1.left<right 是严格小于
		// 2.right在变换的时候，是mid-1；
		// 3.left在变换的时候，是mid+1；
		while (left < right) {
			boolean flag = isBadVersion(mid);
			if (flag) {
				if (mid == 1 || !isBadVersion(mid - 1))
					return mid;
				else
					right = mid - 1;
			} else
				left = mid + 1;
			mid = left + (right - left) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstBadVersion(5));
	}
}
