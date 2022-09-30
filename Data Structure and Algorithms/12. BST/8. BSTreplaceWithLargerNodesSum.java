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
    
    static int max;

	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		
        if(root==null)
            return;
        
        replaceWithLargerNodesSum(root.right);
        
        max = max +root.data;
        root.data = max;
        
        replaceWithLargerNodesSum(root.left);
        
	}
}

class Test {

	public static void main(String[] args) {

		int a[] = { 4 ,2, 6, 1 ,3 ,5, 7};
		
		BinaryTreeNode<Integer> root = createBST(a);
		printInorder(root);
		Solution.replaceWithLargerNodesSum(root);
		System.out.println();
		printInorder(root);
		
	}

	public static void printInorder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

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
	
	public static BinaryTreeNode<Integer> createBST(int[] arr){
		
		BinaryTreeNode<Integer> root = null;
		
		for(int i:arr)
			root = insertNode(root,i);
		
		return root;
	}
}
