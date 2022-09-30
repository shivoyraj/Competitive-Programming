class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	private static int length(LinkedListNode<Integer> head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		
		int n = length(head);
		
		for (int i = 0; i < (n - 1); i++) {
			LinkedListNode<Integer> prev = null;
			LinkedListNode<Integer> curr = head;
			for (int j = 0; j < (n - i - 1); j++) {
				if (curr.data <= curr.next.data) {
					prev = curr;
					curr = curr.next;
				} else {
					if (prev == null) {
						LinkedListNode<Integer> fwd = curr.next;
						head = head.next;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
					} else {
						LinkedListNode<Integer> fwd = curr.next;
						prev.next = fwd;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
					}
				}
			}
		}
		return head;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 0, 9, 2 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		head = Solution.bubbleSort(head);
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
