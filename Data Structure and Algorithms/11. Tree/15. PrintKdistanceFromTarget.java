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

	public static void rootToNode(BinaryTreeNode<Integer> root, int k) {

		if (root == null || k < 0)
			return;

		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		rootToNode(root.left, k - 1);
		rootToNode(root.right, k - 1);
	}

	private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int node, int k) {

		if (root == null)
			return -1;

		if (root.data == node) {
			rootToNode(root, k);
			return 0;
		}

		int dl = nodesAtDistanceKHelper(root.left, node, k);

		if (dl != -1) {

			if (dl + 1 == k)
				System.out.println(root.data);
			else
				rootToNode(root.right, k - dl - 2);

			return 1 + dl;
		}

		int dr = nodesAtDistanceKHelper(root.right, node, k);

		if (dr != -1) {

			if (dr + 1 == k)
				System.out.println(root.data);
			else
				rootToNode(root.left, k - dr - 2);

			return 1 + dr;
		}
		
		return -1;
	}

	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		nodesAtDistanceKHelper(root, node, k);
	}

}

class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1 };

		BinaryTreeNode<Integer> root = createList(a, 0);
		Solution.nodesAtDistanceK(root, 3, 3);
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
