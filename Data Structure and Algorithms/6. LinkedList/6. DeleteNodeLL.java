class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

    public static LinkedListNode<Integer> deleteNodeAtIndexRecursion(LinkedListNode<Integer> head, int pos) {
		
		if (head == null)
			return head;
		
		if (pos == 0) 
			return head.next;
		
		
		LinkedListNode<Integer> smallHead = deleteNodeAtIndexRecursion(head.next, pos - 1);
		head.next = smallHead;
		return head;
	}
    
	public static LinkedListNode<Integer> deleteNodeAtIndex(LinkedListNode<Integer> head, int pos) {

		if (pos == 0 && head != null) 
			return head.next;

		int index = 0;
		LinkedListNode<Integer> p = head;

		while (index != pos - 1 && p != null) {
			index++;
			p = p.next;
		}

		if (p != null && p.next != null)
			p.next = p.next.next;

		return head;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		LinkedListNode<Integer> head = createList(a);
		print(head);

		// Deletion at beg
		head = Solution.deleteNodeAtIndex(head, 0);
		print(head);

		// Deletion at mid
		head = Solution.deleteNodeAtIndex(head, 3);
		print(head);

		// Deletion at end
		head = Solution.deleteNodeAtIndex(head, 6);
		print(head);

		// Deletion with invalid index
		head = Solution.deleteNodeAtIndex(head, -9);
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

	public static LinkedListNode<Integer> createList(int[] a) {

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
