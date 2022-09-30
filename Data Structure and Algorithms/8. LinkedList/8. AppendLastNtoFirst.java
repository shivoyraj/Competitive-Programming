class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		
        if (n == 0 || head == null) 
			return head;
		
        LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> slow = head;
        
		for (int i = 0; i < n && fast!=null; i++)
			fast = fast.next;
        
		while (fast!=null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
        
		LinkedListNode<Integer> newHead = slow.next;
		slow.next = null;
		fast.next = head;
		
		return newHead;
        
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9};

		LinkedListNode<Integer> head = AsList(a);
		print(head);
		head = Solution.appendLastNToFirst(head,4);
		print(head);
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
