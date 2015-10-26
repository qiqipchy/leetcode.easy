import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> nums = new ArrayList<Integer>();
		// 刚开始没有的元素，不能使用set(1,0)这样指定下标的方法，需要使用add，这样才是有元素，添加了元素
		// 才能根据元素的个数来进行合适的取下标操作；
		nums.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int k = i - 1; k >= 1; k--)
				nums.set(k, nums.get(k) + nums.get(k - 1));
			nums.add(1);
		}
		return nums;
	}

	public static void main(String[] args) {
		int numRows = 0;
		System.out.println(new Solution().getRow(numRows));
	}
}
