/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head;
		ListNode evenHead = head.next;
		ListNode even = head.next;
		while (even != null) {
			// 注意中间的这个相互copy的顺序；
			odd.next = even.next;
			if (odd.next == null)
				break;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 4, 3, 6, 5, 8, 7 };
		ListThing listThing = new ListThing(nums);
		new Solution().oddEvenList(listThing.root);
		listThing.print(listThing.root);
	}
}
