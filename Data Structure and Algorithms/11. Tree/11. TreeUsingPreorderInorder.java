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
	
    static int preIndex = 0;
	
	public static int search(int[] a,int strt, int end,int x) {
		
		for(int i=strt;i<=end;i++)
			if(a[i]==x)
				return i;
		
		return -1;
	}
	
	public static BinaryTreeNode<Integer> build(int[] inOrder, int[]preOrder,int startIndex,int endIndex) {
		
		 if (startIndex > endIndex)
	            return null;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preIndex++]);

		if(startIndex == endIndex)
			return root;
			
		int rootIndex = search(inOrder,startIndex,endIndex,root.data);
			
		root.left = build(inOrder,preOrder,startIndex,rootIndex-1);
		root.right = build(inOrder,preOrder,rootIndex+1,endIndex);	
	
		
		return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		
		BinaryTreeNode<Integer> root = build(inOrder,preOrder,0,preOrder.length-1);
		
		return root;

	 }
}

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 1,2,3,4,5,6,7,-1,-1,-1,-1,-1,-1,-1,-1};
		
		int[] pre = {1 ,2 ,4 ,5 ,3 ,6 ,7 };
		int[] in =  {4 ,2 ,5 ,1, 6, 3, 7}; 
		
		BinaryTreeNode<Integer> root = Solution.buildTree(pre,in);
			
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
