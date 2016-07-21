class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	boolean flag = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return flag;
		dfs(root, 0);
		return flag;

	}

	private int dfs(TreeNode root, int depth) {
		// TODO Auto-generated method stub

		int left = depth, right = depth;
		if (root.left != null)
			left = dfs(root.left, depth + 1);
		if (!flag)
			return -1;
		if (root.right != null)
			right = dfs(root.right, depth + 1);
		if (!flag)
			return -1;
		if (Math.abs(right - left) > 1)
			flag = false;
		// 主要的点是在这里，子树的高度是左子树和右子树的高度中较大的那一个；
		return Math.max(left, right);

	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		String data = "5,2,3,null,null,2,4,3";
		TreeNode root = codec.deserialize(data);
		System.out.println(new Solution().isBalanced(root));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
