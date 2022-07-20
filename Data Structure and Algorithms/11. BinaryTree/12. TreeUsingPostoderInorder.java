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
	
    static int postIndex;
	
	public static int search(int[] a,int strt, int end,int x) {
		
		for(int i=strt;i<=end;i++)
			if(a[i]==x)
				return i;
		
		return -1;
	}
	
	public static BinaryTreeNode<Integer> build(int[] inOrder, int[]postOrder,int startIndex,int endIndex) {
		
		 if (startIndex > endIndex)
	            return null;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postIndex--]);

		if(startIndex == endIndex)
			return root;
			
			int rootIndex = search(inOrder,startIndex,endIndex,root.data);
			
        	root.right = build(inOrder,postOrder,rootIndex+1,endIndex);	
			root.left = build(inOrder,postOrder,startIndex,rootIndex-1);
	
		
		return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		
		postIndex = postOrder.length-1;
		BinaryTreeNode<Integer> root = build(inOrder,postOrder,0,postOrder.length-1);
		
		return root;

	 }
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 1,2,3,4,5,6,7,-1,-1,-1,-1,-1,-1,-1,-1};
		
		int[] post = {2,9,3,6,10,5};
		int[] in =  {2,6,3,9,5,10}; 
		
		BinaryTreeNode<Integer> root = Solution.buildTree(post,in);		
		levelOrder(root);
	}
	
    public static void levelOrder(BinaryTreeNode<Integer> root) {
    	
    	if(root==null)
    		return;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(new BinaryTreeNode<>(Integer.MAX_VALUE));

		while (queue.size()!=1) {
			
			BinaryTreeNode<Integer> peek =  queue.remove();
			
			System.out.print(peek.data+" ");
			
			if(peek.left!=null)
				queue.add(peek.left);

			if(peek.right!=null)
				queue.add(peek.right);
						
			if(queue.peek().data.equals(Integer.MAX_VALUE)) {
				System.out.println();
				queue.remove();
				queue.add(new BinaryTreeNode<>(Integer.MAX_VALUE));
			}
			
		}
	}

}
