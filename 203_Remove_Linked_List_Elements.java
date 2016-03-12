public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode iter = head, pre = head;
		while (iter != null) {
			if (iter.val == val)
				pre.next = iter.next;
			else
				pre = iter;
			iter = iter.next;
		}
		while (head != null && head.val == val)
			head = head.next;
		return head;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 6, 6, 6, 6, 1, 2, 3, 4, 5, 6, 6, 6 };
		ListThing list = new ListThing(nums);
		list.root = new Solution().removeElements(list.root, 6);
		list.print(list.root);
	}
}
