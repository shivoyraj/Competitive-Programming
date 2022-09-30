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

class NodeValue{
    
    int min;
    int max;
    boolean isBST;
    int height;
    
}

class Solution {
    
    public static NodeValue largestBSThelper(BinaryTreeNode<Integer> root){
        
        if(root == null){
            NodeValue nodeValue = new NodeValue();
            nodeValue.max = Integer.MIN_VALUE;
            nodeValue.min = Integer.MAX_VALUE;
            nodeValue.isBST = true;
            nodeValue.height = 0;
            return nodeValue;
        }
        
        NodeValue left  = largestBSThelper(root.left);
        NodeValue right = largestBSThelper(root.right);
        
        NodeValue nodeValue = new NodeValue();
        
        int min = Math.min(root.data,Math.min(left.min,right.min));
        int max = Math.max(root.data,Math.max(left.max,right.max));
        
        nodeValue.min = min;
        nodeValue.max = max;
        
        nodeValue.isBST = left.max < root.data && right.min > root.data && left.isBST && right.isBST;
        
        if(nodeValue.isBST)
            nodeValue.height = 1 + Math.max(left.height,right.height);
        
        else
            nodeValue.height = Math.max(left.height,right.height);
        
        return nodeValue;   
    }
    
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSThelper(root).height;
	}
    
}

class Test {

	public static void main(String[] args) {

		int a[] = { 4, 2, 5, 6, -1, -1, -1, -1, -1 };

		BinaryTreeNode<Integer> root = createBT(a, 0);
		System.out.println(Solution.largestBSTSubtree(root));
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
