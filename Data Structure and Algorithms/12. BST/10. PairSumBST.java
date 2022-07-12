import java.util.Stack;

class BinaryTreeNode<T> {

	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "" + data;
	}
}

class Solution{

	public static void addLefts(BinaryTreeNode<Integer> root,Stack<BinaryTreeNode<Integer>> s) {
		if(root==null)
			return;
		
		s.push(root);
		addLefts(root.left,s);
	}
	
	public static void addRights(BinaryTreeNode<Integer> root,Stack<BinaryTreeNode<Integer>> s) {
		if(root==null)
			return;
		
		s.push(root);
		addRights(root.right,s);
	}
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		
		if(root==null)
			return;
		
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		
		addLefts(root,s1);
		addRights(root,s2);
		
		while(s1.peek()!=s2.peek()) {
            
	        int x1 = s1.peek().data;
	        int x2 = s2.peek().data;
			
			if(x1+x2<s) 
				addLefts(s1.pop().right,s1);
			
			else if (x1+x2>s)
				addRights(s2.pop().left,s2);
			
			else{
				System.out.println(x1+" "+x2);
				addLefts(s1.pop().right,s1);
			}
				
		}
	}

}
class Test {

	public static void main(String[] args) {

		int a[] = {11,12,13,14,15};
		BinaryTreeNode<Integer> root = createBST(a);
		Solution.printNodesSumToS(root, 26);
	}

	public static BinaryTreeNode<Integer> insertNode(BinaryTreeNode<Integer> root, int n) {

		if (root == null)
			root = new BinaryTreeNode<>(n);

		else if (root.left == null && n < root.data)
			root.left = new BinaryTreeNode<>(n);

		else if (root.left != null && n < root.data)
			insertNode(root.left, n);

		else if (root.right == null && n > root.data)
			root.right = new BinaryTreeNode<>(n);

		else if (root.right != null && n > root.data)
			insertNode(root.right, n);

		return root;
	}

	public static BinaryTreeNode<Integer> createBST(int[] arr) {

		BinaryTreeNode<Integer> root = null;

		for (int i : arr)
			root = insertNode(root, i);

		return root;
	}
}
