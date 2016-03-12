public class Solution {
	public TreeNode invertTree(TreeNode root) {
		invertRec(root);
		return root;
	}

	private void invertRec(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertRec(root.left);
		invertTree(root.right);
	}

	public static void main(String[] args) {
		TreeThing treething = new TreeThing();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = treething.buildTree(null, nums);
		new Solution().invertTree(root);
		treething.print(root);
	}
}
