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
	
	//Replace position with left most node of right of target value
	public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {

		if (root == null)
			return root;

		if (key < root.data)
			root.left = deleteNode(root.left, key);

		else
			root.right = deleteNode(root.right, key);

		if (root.data == key) {

			if (root.left == null && root.right == null)
				return null;

			if (root.right == null)
				return root.left;

			else if (root.left == null)
				return root.right;

			else {
				
                BinaryTreeNode<Integer> minNode = root.right;
                
                while(minNode.left != null)
                    minNode = minNode.left;
                
                root.data = minNode.data;
                root.right = deleteNode(root.right, minNode.data);
			}

		}

		return root;
	}

}

class Test {

	public static void main(String[] args) {

		int a[] = { 5, 3, 6, 2, 4, 7 };

		BinaryTreeNode<Integer> root = createBST(a);
		levelOrder(root);
		root = Solution.deleteNode(root, 3);
		System.out.println();
		levelOrder(root);
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

	public static BinaryTreeNode<Integer> createBST(int[] arr) {

		BinaryTreeNode<Integer> root = null;

		for (int i : arr)
			root = insertNode(root, i);

		return root;
	}
}
