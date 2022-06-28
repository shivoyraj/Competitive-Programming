class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		
		LinkedListNode<Integer> p = head;
		LinkedListNode<Integer> q = head;
		
		if(M==0)
			return null;
		
		if(N==0)
			return head;
		
		while(q!=null) {
			
			int a = M;
			int b = N;
			
			//since current pointer p is already on head
			if(q==head)
				a--;
			
			//skipping first M elements
			while(q!=null && p!=null && a>0) {
				a--;
				q=q.next;
				p=p.next;
			}
			
			// forwarding q pointer to next N elements
			while(q!=null && b>0) {
				q=q.next;
				b--;
			}
			
			// setting q as next of p
			if(q!=null && p!=null)
				p.next = q.next;
			
			// if q is null then setting p as last elements
			if(q==null && p!=null)
				p.next = null;
			
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
