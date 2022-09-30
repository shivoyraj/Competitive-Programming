import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
	}
}

class Solution {

	public static TreeNode<Integer> constructBBST(List<Integer> arr, int i, int j) {

		TreeNode<Integer> root = null;

		if (i <= j) {
			int m = (i + j) / 2;
			root = new TreeNode<>(arr.get(m));
			root.left = constructBBST(arr, i, m - 1);
			root.right = constructBBST(arr, m + 1, j);
		}

		return root;
	}

	public static TreeNode<Integer> constructBBST(List<Integer> arr, int n) {
		return constructBBST(arr, 0, n - 1);
	}

	static TreeNode<Integer> mergeBST(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode<Integer>> s1 = new Stack<>();
		Stack<TreeNode<Integer>> s2 = new Stack<>();

		while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {

			while (root1 != null) {
				s1.push(root1);
				root1 = root1.left;
			}

			while (root2 != null) {
				s2.push(root2);
				root2 = root2.left;
			}

			if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().data <= s2.peek().data)) {
				root1 = s1.peek();
				s1.pop();
				res.add(root1.data);
				root1 = root1.right;
			} else {
				root2 = s2.peek();
				s2.pop();
				res.add(root2.data);
				root2 = root2.right;
			}
		}
		return constructBBST(res, res.size());
	}

}