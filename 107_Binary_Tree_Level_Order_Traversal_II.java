/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<TreeNode> listOne = new ArrayList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

		if (root == null)
			return list;
		queue.add(root);
		map.put(root, 1);
		listOne.add(root);

		while (queue.size() > 0) {
			TreeNode temp = queue.poll();
			if (temp.left != null) {
				queue.add(temp.left);
				map.put(temp.left, map.get(temp) + 1);
				listOne.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
				map.put(temp.right, map.get(temp) + 1);
				listOne.add(temp.right);
			}
		}
		// 从最后的算起；
		int temp = 1;
		List<Integer> list1 = new ArrayList<Integer>();
		for (TreeNode node : listOne) {
			if (map.get(node) == temp)
				list1.add(node.val);
			else {
				list.add(new ArrayList<Integer>(list1));
				list1.clear();
				list1.add(node.val);
				temp++;
			}
		}
		// 每一层的顺序是不变的，但是层与层之间的顺序是变化的，所以将listOne分组之后进行倒置；
		// 如果将listOne先倒置再分组的话，每一层的顺序也是倒置的；
		list.add(list1);
		Collections.reverse(list);
		System.out.println(list);
		return list;
	}


}
