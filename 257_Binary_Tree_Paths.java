import java.util.ArrayList;
import java.util.List;

public class Solution {
	String string = "";

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null)
			return list;
		dfs(root, list);
		return list;
	}

	private void dfs(TreeNode root, List<String> list) {
		// TODO Auto-generated method stub

		string += root.val + "->";
		if (root.left == null && root.right == null) {
			list.add(string.substring(0, string.length() - 2));
			return;
		}
		int length = string.length();
		if (root.left != null) {
			dfs(root.left, list);
		}
		string = string.substring(0, length);
		if (root.right != null) {
			dfs(root.right, list);
		}
	}

	public static void main(String[] args) {
		TreeNode root = null;
		int[] nums = { 1, 2, 3, 4 };
		root = new TreeThing().buildTree(root, nums);
		System.out.println(new Solution().binaryTreePaths(root));
	}
}
