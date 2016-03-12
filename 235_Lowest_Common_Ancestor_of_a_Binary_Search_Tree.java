public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 这里简单的写为left=p.val;right=q.val是会出事情的，因为用的是比较，默认的是right要比left大；
		int middle = root.val, left = p.val < q.val ? p.val : q.val, right = p.val > q.val ? p.val
				: q.val;

		while (root != null) {
			if (root.val == left || root.val == right)
				return root;
			middle = root.val;
			if (left < middle && middle < right)
				return root;
			if (left > middle && right > middle)
				root = root.right;
			else if (left < middle && right < middle)
				root = root.left;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode left = new TreeNode(1);
		root.left = left;
		root.right = right;
		System.out.println(new Solution().lowestCommonAncestor(root, left,
				right).val);

	}
}
