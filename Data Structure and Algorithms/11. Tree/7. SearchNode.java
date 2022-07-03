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

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {

		if (root == null)
			return false;

		if (root.data.equals(x))
			return true;

		return isNodePresent(root.left, x) || isNodePresent(root.right, x);
	}
}

class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 2, 35, 10, 2, 3, 5, 2, -1, -1, -1, -1, -1, -1, -1, -1 };

		BinaryTreeNode<Integer> root = createList(a, 0);

		System.out.println(Solution.isNodePresent(root, 3));

	}

	public static BinaryTreeNode<Integer> createList(int[] a, int i) {

		if (a.length == 0)
			return null;

		if (i < a.length && a[i] == -1)
			return null;

		BinaryTreeNode<Integer> root = null;

		if (i < a.length) {
			root = new BinaryTreeNode<>(a[i]);
			root.left = createList(a, 2 * i + 1);
			root.right = createList(a, 2 * i + 2);
		}

		return root;
	}

}
