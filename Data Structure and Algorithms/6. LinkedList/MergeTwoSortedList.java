class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    	    	
    	LinkedListNode<Integer> p1 = head1;
    	LinkedListNode<Integer> p2 = head2;
    	LinkedListNode<Integer> newHead = new LinkedListNode<>(0);
    	LinkedListNode<Integer> p = newHead;
    	
    	while(p1!=null && p2!=null) {
            
            LinkedListNode<Integer> temp;
    		
    		if(p1.data>p2.data) {
    			temp = new LinkedListNode<>(p2.data);
    			p2=p2.next;
    		}
    		else {
    			temp = new LinkedListNode<>(p1.data);
    			p1=p1.next;
    		}
            
            p.next=temp;
    		p=p.next;
    	}
    	
    	if (p1!=null)
    		p.next = p1;
    	
    	if (p2!=null)
    		p.next = p2;
    	
        return newHead.next;
    }
}

class Test {

	public static void main(String[] args) {
		
		int[] a = { 10 ,10 ,22 };
		int[] b = { 3 ,8 ,8 ,36};
		
		LinkedListNode<Integer> head = AsList(a);
		LinkedListNode<Integer> head2 = AsList(b);
		print(head);
		print(head2);
		head = Solution.mergeTwoSortedLinkedLists(head,head2);
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
