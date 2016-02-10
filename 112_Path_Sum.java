class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	boolean flag;

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null && sum == 0)
			return true;
		if (root == null && sum != 0)
			return false;
		dfs(root, 0);
		return flag;

	}

	private void dfs(TreeNode root, int sum) {
		// TODO Auto-generated method stub
		if (root.left == null && root.right == null) {
			if (sum + root.val == sum)
				flag = true;
			else
				return;
		}
		if (root.left != null)
			dfs(root.left, sum + root.val);
		if (flag == true)
			return;
		if (root.right != null)
			dfs(root.right, sum + root.val);
	}
}
