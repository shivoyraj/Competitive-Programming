class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}


class Solution {

	public static void printReverse(LinkedListNode<Integer> root) {
       
        if(root==null)
            return;
        
		printReverse(root.next);
        System.out.print(root.data+" ");    
	}

}

class Test {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7};
		
		LinkedListNode<Integer> head = AsList(a);
		print(head);
		Solution.printReverse(head);
	}

	public static void print(LinkedListNode<Integer> head) {

		while (head != null) {
			System.out.print(head.data + " ->");
			head = head.next;
		}
		System.out.print("null");
		System.out.println();

	}

	public static LinkedListNode<Integer> AsList(int[] a) {

		if (a.length == 0)
			return null;

		LinkedListNode<Integer> head = new LinkedListNode<Integer>(a[0]);
		LinkedListNode<Integer> p = head;

		for (int i = 1; i < a.length; i++) {
			p.next = new LinkedListNode<Integer>(a[i]);
			p = p.next;
		}

		return head;

	}

}
