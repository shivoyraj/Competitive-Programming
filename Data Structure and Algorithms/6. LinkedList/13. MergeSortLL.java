class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head){
        
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next; 
            slow = slow.next;
        }
        
        return slow;
    }

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
    
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
    	
        if(head==null || head.next==null)
            return head;
        
        LinkedListNode<Integer> head1 = head;
        LinkedListNode<Integer> res = getMid(head);
        LinkedListNode<Integer> head2 = res.next;
        res.next = null;
        
        LinkedListNode<Integer> tmp1 = mergeSort(head1);
        LinkedListNode<Integer> tmp2 = mergeSort(head2);
        
        LinkedListNode<Integer> temp = mergeTwoSortedLinkedLists(tmp1,tmp2);
        
        return temp;
    }

}

class Test {

	public static void main(String[] args) {

		int[] a = {2,1,4,3,6,5,8,7};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		
		head = Solution.mergeSort(head);
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
