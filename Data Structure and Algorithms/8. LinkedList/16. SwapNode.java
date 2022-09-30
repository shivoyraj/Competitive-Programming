class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {

	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {

		if (i == j)
			return head;

		LinkedListNode<Integer> currentNode = head, prev = null;
		LinkedListNode<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;

		int pos = 0;
		int totalNode = 0;

		while (currentNode != null) {

			if (pos == i) {
				firstNodePrev = prev;
				firstNode = currentNode;
			} else if (pos == j) {
				secondNodePrev = prev;
				secondNode = currentNode;
			}

			prev = currentNode;
			currentNode = currentNode.next;
			pos++;
			totalNode++;
		}
		
		if(i>totalNode || j>totalNode)
			return head;
		
		if (firstNodePrev != null)
			firstNodePrev.next = secondNode;
		else
			head = secondNode;

		if (secondNodePrev != null)
			secondNodePrev.next = firstNode;
		else
			head = firstNode;

		LinkedListNode<Integer> temp = secondNode.next;
		secondNode.next = firstNode.next;
		firstNode.next = temp;
		return head;

	}

}

class Test {

	public static void main(String[] args) {

		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 0, 9, 2 };

		LinkedListNode<Integer> head = createList(a);
		print(head);
		head = Solution.swapNodes(head, 2, 19);
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
