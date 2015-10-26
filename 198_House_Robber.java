

public class Solution {
	public int rob(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[] maxEach = new int[nums.length];
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];
		maxEach[0] = nums[0];
		maxEach[1] = nums[0] > nums[1] ? nums[0] : nums[1];
		for (int i = 2; i < nums.length; i++) {
			// 动态规划中主要是找到子问题的描述方式，以及中间的状态转换；
			if (maxEach[i - 2] + nums[i] > maxEach[i - 1])
				maxEach[i] = maxEach[i - 2] + nums[i];
			else
				maxEach[i] = maxEach[i - 1];
			max = max > maxEach[i] ? max : maxEach[i];
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 2, 2, 10 };
		System.out.println(new Solution().rob(nums));
	}
}
