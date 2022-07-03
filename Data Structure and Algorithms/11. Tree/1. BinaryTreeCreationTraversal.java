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

public class Test {

	public static void main(String[] args) {

		// tree is stored in level order traversal
		// if root at i its left child is at 2*i+1 and right child is at 2*i+2
		int a[] = { 5 ,6 ,10 ,2 ,3 ,-1 ,-1 ,-1 ,-1 ,-1 ,9 ,-1 ,-1};
		
		BinaryTreeNode<Integer> root = createList(a, 0);
		printPreorder(root);
		System.out.println();
		printInorder(root);
		System.out.println();
		printPostorder(root);
        System.out.println();
        levelOrder(root);

	}

    // it is assumed that intput array is based of completed binary tree
	public static BinaryTreeNode<Integer> createList(int[] a, int i) {

		if (a.length == 0)
			return null;
		
		if(i<a.length && a[i]==-1)
			return null;

		BinaryTreeNode<Integer> root = null;

		if (i < a.length) {
			root = new BinaryTreeNode<>(a[i]);
			root.left = createList(a, 2 * i + 1);
			root.right = createList(a, 2 * i + 2);
		}

		return root;
	}

    public static void levelOrder(BinaryTreeNode<Integer> root) {

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

	public static void printInorder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	public static void printPostorder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");

	}

	public static void printPreorder(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");

		printPreorder(root.left);
		printPreorder(root.right);
	}

}
