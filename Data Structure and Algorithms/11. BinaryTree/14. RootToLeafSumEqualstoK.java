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
	
	public static void helper(BinaryTreeNode<Integer> root, int k,String path) {
		
		if(root==null)
			return;
		
		path = path +" "+ root.data;
		
		if(root.left==null && root.right == null && root.data-k==0)
			System.out.println(path);
		
		helper(root.left,k-root.data,path);
		helper(root.right,k-root.data,path);
	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		
		helper(root,k,"");
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 2,2,2,2,2,2,2,-1,-1,-1,-1,-1,-1,-1,-1};
		
		BinaryTreeNode<Integer> root = createBT(a, 0);
		Solution.rootToLeafPathsSumToK(root, 6);
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
