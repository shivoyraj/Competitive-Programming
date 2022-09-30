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

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {

        if(root==null)
			return;
		
		if(root.left!=null && root.right==null)
			System.out.print(root.left.data+" ");
		
		if(root.left==null && root.right!=null)
			System.out.print(root.right.data+" ");
		
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = {2,4,5,6,-1,-1,7,20,30,80,90,-1,-1,-1,-1,-1,-1,-1,-1 };

		BinaryTreeNode<Integer> root = createBT(a, 0);

		Solution.printNodesWithoutSibling(root);

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

}
