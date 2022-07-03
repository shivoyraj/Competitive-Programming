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
    // if node is only one then height is 1 
	public static int height(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return 0;
		
		int leftHeight  = 1 + height(root.left);
		int rightHeight  = 1 + height(root.right);

		return Math.max(leftHeight, rightHeight);
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 10,20,30,40,50,-1,-1,-1,-1,-1,-1};
		
		BinaryTreeNode<Integer> root = createList(a, 0);
		
		System.out.println(Solution.height(root));
	}

	public static BinaryTreeNode<Integer> createList(int[] a, int i) {

		if (a.length == 0)
			return null;
		
		if(i<a.length && a[i]==-1)
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
