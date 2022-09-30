import java.util.ArrayList;
import java.util.List;

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
    
	static ArrayList<Integer> list = new ArrayList<>();

	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		
        if(root==null)
            return new ArrayList<>();
        
        list.add(0,root.data);
        
        if(root.data==data)
            return list;
        
        if(data<root.data)
	        return getPath(root.left,data);
        
        else
	        return getPath(root.right,data);
	}
}

class Test {

	public static void main(String[] args) {

		int a[] = { 4 ,2, 6, 1 ,3 ,5, 7};
		
		BinaryTreeNode<Integer> root = createBST(a);
		// will print from node to root
		List<Integer> res = Solution.getPath(root,7);
		System.out.println(res);
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
