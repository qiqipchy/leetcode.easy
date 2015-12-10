
class NumArray {

	int[] res;

	public NumArray(int[] nums) {
		res = new int[nums.length];
		if (nums.length == 0)
			return;
		res[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] + nums[i];
		System.out.println(Arrays.toString(res));
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return res[j];
		return res[j] - res[i - 1];
	}
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
