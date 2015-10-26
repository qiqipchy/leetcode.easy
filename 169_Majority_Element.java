import java.util.Arrays;

public class Solution {
	public int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			// 注意是多于；
			if (nums[i + nums.length / 2] == nums[i])
				return nums[i];
			else {
				// 两种不同的写法代表的是不同的i，最后跳出循环的位置；
				while (i < nums.length - 1 && nums[i + 1] == nums[i])
					i++;
			}
			i++;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };
		System.out.println(new Solution().majorityElement(nums));
	}
}
