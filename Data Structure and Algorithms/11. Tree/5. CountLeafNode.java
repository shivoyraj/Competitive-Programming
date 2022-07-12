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
    
	public static int countLeafNode(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return 1;
		
		return countLeafNode(root.left) + countLeafNode(root.right);
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = {1,2,3,4,5,5,6};
		
		BinaryTreeNode<Integer> root = createBT(a, 0);
		
		System.out.println(Solution.countLeafNode(root));

	}

	public static BinaryTreeNode<Integer> createBT(int[] a, int i) {

		if (a.length == 0)
			return null;
		
		if(i<a.length && a[i]==-1)
			return null;

		BinaryTreeNode<Integer> root = null;

		if (i < a.length) {
			root = new BinaryTreeNode<>(a[i]);
			root.left = createBT(a, 2 * i + 1);
			root.right = createBT(a, 2 * i + 2);
		}

		return root;
	}

}
