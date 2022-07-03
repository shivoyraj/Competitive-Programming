class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	// indexing start with 0
	public static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head, int pos, int data){
        
        LinkedListNode<Integer> node = new LinkedListNode<>(data);
        
        if(pos==0){
            node.next = head;
            head = node;
            return head;
        }
		
		int index = 0;
		LinkedListNode<Integer> p  = head;
		
		while(index!=pos-1 && p!=null) {
			p=p.next;
            index++;
		}
		
        
        if(p!=null){
			node.next = p.next;
			p.next=node;
        }
		
		return head;
	
	}
    
}

class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		
		// inserting at beg
		head = Solution.insertNode(head, 0, 11);
		print(head);
		
		// inserting at mid
		head = Solution.insertNode(head, 3, 33);
		print(head);
		
		// inserting at end
		head = Solution.insertNode(head, 11, 77);
		print(head);
		
		//inserting with invalid index
		head = Solution.insertNode(head, 32, 33);
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
