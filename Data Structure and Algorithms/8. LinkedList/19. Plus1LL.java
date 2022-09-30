class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {

		if (head == null)
			return null;

		int carry = addElement(head);

		if (carry > 0) {
			LinkedListNode<Integer> carryNode = new LinkedListNode<Integer>(carry);
			carryNode.next = head;
			return carryNode;
		}
		return head;
	}

	private static int addElement(LinkedListNode<Integer> head) {

		if (head == null)
			return 1;

		int c = head.data + addElement(head.next);
		head.data = c % 10;

		return c / 10;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 9, 9, 9, 9 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		head = Solution.nextLargeNumber(head);
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
