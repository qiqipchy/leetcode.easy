import java.util.Arrays;

public class Solution {
	public void rotate(int[] nums, int k) {
		int[] temp = new int[nums.length];
		System.arraycopy(nums, 0, temp, 0, nums.length);
		k %= nums.length;
		System.arraycopy(temp, 0, nums, k, nums.length - k);
		System.arraycopy(temp, nums.length - k, nums, 0, k);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		new Solution().rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}
}
