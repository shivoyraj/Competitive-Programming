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
		
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		
		if(root==null)
			return false;
		
		if(root.data.equals(k))
			return true;
		
		if(k>root.data)
			return searchInBST(root.right,k);
		else
			return searchInBST(root.left,k);
		
	}

}
class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = {8 ,5 ,10 ,2, 6,7};

		//BinaryTreeNode<Integer> root = createList(a, 0);
		BinaryTreeNode<Integer> root  = createBST(a,a.length);
		levelOrder(root);
		System.out.println(Solution.searchInBST(root,7));
		System.out.println(Solution.searchInBST(root,18));
	}
	
	public static BinaryTreeNode<Integer> insertNode(BinaryTreeNode<Integer>  root,int n) {
		
		
		if(root==null) 
			root = new BinaryTreeNode<>(n);
		
		else if(root.left==null && n<root.data)
			root.left =  new BinaryTreeNode<>(n);
		
		else if(root.left!=null && n<root.data)
			insertNode(root.left,n);
		
		else if(root.right==null && n>root.data)
			root.right =  new BinaryTreeNode<>(n);
		
		else if(root.right!=null && n>root.data)
			insertNode(root.right,n);
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> createBST(int[] arr, int n){
		
		BinaryTreeNode<Integer> root = null;
		
		for(int i:arr)
			root = insertNode(root,i);
		
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
