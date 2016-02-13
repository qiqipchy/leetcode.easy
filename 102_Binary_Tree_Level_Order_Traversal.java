import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
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

		int temp = 1;
		List<Integer> list1 = new ArrayList<Integer>();
		for (TreeNode node : listOne) {
			// System.out.print(node.val + " " + map.get(node) + "\t");
			if (map.get(node) == temp)
				list1.add(node.val);
			else {
				list.add(new ArrayList<Integer>(list1));
				list1.clear();
				list1.add(node.val);
				temp++;
			}
		}
		list.add(list1);
		// System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		TreeNode root = null;
		root = new TreeThing().buildTree(root, nums);
		new Solution().levelOrder(root);
	}
}
