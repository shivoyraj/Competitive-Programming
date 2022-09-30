class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	public static void replaceDuplicatesbyPlusPlusMax(LinkedListNode<Integer> head) {

		int max = Integer.MIN_VALUE;
		LinkedListNode<Integer> p = head;

		while (p != null) {
			max = Math.max(max, p.data);
			p = p.next;
		}

		int[] map = new int[max + 1];
		boolean[] flag = new boolean[max + 1];

		p = head;

		while (p != null) {

			if (map[p.data] == 0)
				map[p.data] = 1;

			else
				map[p.data] = map[p.data] + 1;

			p = p.next;
		}

		p = head;
		while (p != null) {

			if (!flag[p.data])
				flag[p.data] = true;

			else if (map[p.data] >= 1 && flag[p.data]) {
				map[p.data]--;
				p.data = ++max;
			}

			p = p.next;
		}

	}
}

class Test{

	public static void main(String[] args) {

		int[] a = { 1, 3, 1, 4, 4, 2, 1 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		Solution.replaceDuplicatesbyPlusPlusMax(head);
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
