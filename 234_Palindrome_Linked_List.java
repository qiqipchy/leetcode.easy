import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {

			// 注意这里要使用的是equals，而不是==；
			if (!list.get(i).equals(list.get(j)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { -16557, -8725, -29125, 28873, -21702, 15483, -28441,
				-17845, -4317, -10914, -10914, -4317, -17845, -28441, 15483,
				-21702, 28873, -29125, -8725, -16557 };
		// System.out.println(Arrays.toString(nums));
		ListThing head = new ListThing(nums);
		// head.print(head.root);
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(head.root));
	}
}
