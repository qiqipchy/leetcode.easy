/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmeRec(root.left, root.right);
	}

	private boolean isSymmeRec(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if (left == null && right == null)
			return true;
		if (left != null && right != null && left.val == right.val)
			// 两个参数的递归，而且在判断的时候，使用的是两个递归的结果来判断，注意其中的left和right；
			return isSymmeRec(left.left, right.right)
					&& isSymmeRec(left.right, right.left);
		return false;
	}
}
