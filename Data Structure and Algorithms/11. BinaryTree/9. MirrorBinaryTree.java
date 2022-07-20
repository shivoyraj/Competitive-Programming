import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			BinaryTreeNode<Integer> temp = root.left;
			root.left = root.right;
			root.right = temp;
		}

		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1 };

		BinaryTreeNode<Integer> root = createBT(a, 0);
		levelOrder(root);
		Solution.mirrorBinaryTree(root);
		levelOrder(root);

	}

	public static BinaryTreeNode<Integer> createBT(int[] a, int i) {

		if (a.length == 0)
			return null;

		if (i < a.length && a[i] == -1)
			return null;

		BinaryTreeNode<Integer> root = null;

		if (i < a.length) {
			root = new BinaryTreeNode<>(a[i]);
			root.left = createBT(a, 2 * i + 1);
			root.right = createBT(a, 2 * i + 2);
		}

		return root;
	}

	public static void levelOrder(BinaryTreeNode<Integer> root) {

		if(root==null)
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
