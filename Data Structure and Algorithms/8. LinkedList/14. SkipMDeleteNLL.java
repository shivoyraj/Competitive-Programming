class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

		if (M == 0)
			return null;

		if (N == 0)
			return head;

		LinkedListNode<Integer> q = head;
		LinkedListNode<Integer> p = head;

		while (q != null) {

			int a = M;
			int b = N;

			if (q == head)
				a--;

			while (p != null && a-- > 0)
				p = p.next;

			q = p;
			while (q != null && b-- >= 0)
				q = q.next;

			if (p != null)
				p.next = q;

		}
		return head;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = {3,2,0,4};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		
		head = Solution.skipMdeleteN(head,1,1);
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
