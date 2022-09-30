// LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
// It is defined that each node is a descendant to itself, 
// so, if there are two nodes X and Y and X has a direct connection from Y,
// then Y is the lowest common ancestor.


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class Solution {
    	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		
        if(root==null)
            return -1;
        
        if(root.data>a && root.data>b)
            return  getLCA(root.left,a,b);
        
        else if(root.data<a && root.data<b)
            return  getLCA(root.right,a,b);
        
        else
            return root.data;
	}
}