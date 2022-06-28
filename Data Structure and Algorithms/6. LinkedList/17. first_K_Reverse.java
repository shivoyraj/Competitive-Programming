class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {

		if (k == 0 || k == 1)
			return head;

		LinkedListNode<Integer> current = head;
		LinkedListNode<Integer> fwd = null;
		LinkedListNode<Integer> prev = null;

		int count = 0;

		while (count < k && current != null) {
			fwd = current.next;
			current.next = prev;
			prev = current;
			current = fwd;
			count++;
		}

		if (fwd != null)
			head.next = kReverse(fwd, k);

		return prev;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 0, 9, 2 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		head = Solution.kReverse(head,5);
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
