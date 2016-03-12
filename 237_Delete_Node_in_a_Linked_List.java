public class Solution {
	public void deleteNode(ListNode node) {
		if (node == null)
			return;
		// 不再想前面的到底是啥，就从这里开始；
		// 将当前点变成pre，丢弃的其实是第二个点；
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
