class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {

		if (head == null || head.next == null)
			return head;

		LinkedListNode<Integer> evenLL = new LinkedListNode<>(0);
		LinkedListNode<Integer> oddLL = new LinkedListNode<>(0);

		LinkedListNode<Integer> p = head;
		LinkedListNode<Integer> p1 = oddLL;
		LinkedListNode<Integer> p2 = evenLL;

		while (p != null) {
			if (p.data % 2 == 0) {
				p2.next = p;
				p2 = p2.next;
			} else {
				p1.next = p;
				p1 = p1.next;
			}
			p = p.next;
		}

		p1.next = evenLL.next;
		p2.next = null;

		return oddLL.next;
	}

}

class Test {

	public static void main(String[] args) {

		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 0, 9 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		head = Solution.evenAfterOdd(head);
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
