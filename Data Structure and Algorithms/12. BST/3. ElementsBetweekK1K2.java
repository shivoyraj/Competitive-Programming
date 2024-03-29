import java.util.LinkedList;
import java.util.Queue;

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

	  public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {

		 if (root == null) 
			return;
		
		if (root.data >= k1 && root.data <= k2) {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data + " ");
			elementsInRangeK1K2(root.right, k1, k2);
		}
		else if (root.data < k1) 
			elementsInRangeK1K2(root.right, k1, k2);

		else if (root.data > k2) 
			elementsInRangeK1K2(root.left, k1, k2);
	}
}

class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 8, 5, 10, 2, 6, 7, 18 };

		// BinaryTreeNode<Integer> root = createList(a, 0);
		BinaryTreeNode<Integer> root = createBST(a, a.length);
		levelOrder(root);
		Solution.elementsInRangeK1K2(root, 7, 15);
	}

	public static BinaryTreeNode<Integer> insertNode(BinaryTreeNode<Integer> root, int n) {

		if (root == null)
			root = new BinaryTreeNode<>(n);

		else if (root.left == null && n < root.data)
			root.left = new BinaryTreeNode<>(n);

		else if (root.left != null && n < root.data)
			insertNode(root.left, n);

		else if (root.right == null && n > root.data)
			root.right = new BinaryTreeNode<>(n);

		else if (root.right != null && n > root.data)
			insertNode(root.right, n);

		return root;
	}

	public static BinaryTreeNode<Integer> createBST(int[] arr, int n) {

		BinaryTreeNode<Integer> root = null;

		for (int i : arr)
			root = insertNode(root, i);

		return root;
	}

	public static void levelOrder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(new BinaryTreeNode<>(Integer.MAX_VALUE));

		while (queue.size() != 1) {

			BinaryTreeNode<Integer> peek = queue.remove();

			System.out.print(peek.data + " ");

			if (peek.left != null)
				queue.add(peek.left);

			if (peek.right != null)
				queue.add(peek.right);

			if (queue.peek().data.equals(Integer.MAX_VALUE)) {
				System.out.println();
				queue.remove();
				queue.add(new BinaryTreeNode<>(Integer.MAX_VALUE));
			}

		}
	}

}
