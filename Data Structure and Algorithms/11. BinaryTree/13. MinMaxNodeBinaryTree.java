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

class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

class Solution {
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
		
		Pair<Integer, Integer> left  = getMinAndMax(root.left);
		Pair<Integer, Integer> right  = getMinAndMax(root.right);
		
		int max= Math.max(root.data, Math.max(left.maximum,right.maximum ));
		int min= Math.min(root.data, Math.min(left.minimum,right.minimum ));
		
		return new Pair<>(min,max);
	}
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 10,20,30,40,50,-1,60,-1,-1,-1,-1,-1,-1};
		
		
		BinaryTreeNode<Integer> root = createBT(a, 0);
		Pair<Integer, Integer> res = Solution.getMinAndMax(root);
		System.out.println("Minimum "+res.minimum+" Maximum"+ res.maximum);
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
