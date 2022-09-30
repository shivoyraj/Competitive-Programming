class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Solution {

	public static BinaryTreeNode<Integer> constructBBST(int[] arr, int i, int j) {

		BinaryTreeNode<Integer> root = null;
		
		if (i <= j) {
			int m = (i + j) / 2;
			root = new BinaryTreeNode<>(arr[m]);
			root.left = constructBBST(arr, i, m - 1);
			root.right = constructBBST(arr, m + 1, j);
		}

		return root;
	}

	public static BinaryTreeNode<Integer> constructBBST(int[] arr, int n) {
		return constructBBST(arr, 0, n - 1);
	}

}

class Test {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };

        // will create A BST such that each node's left subtree and right subtree height will not differ more than 1
		BinaryTreeNode<Integer> root = Solution.constructBBST(a, a.length);
		printPreorder(root);

	}

	public static void printPreorder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");

		printPreorder(root.left);
		printPreorder(root.right);
	}
}