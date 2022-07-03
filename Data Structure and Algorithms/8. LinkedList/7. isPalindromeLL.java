class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
		
		if(head==null || head.next==null)
			return head;
		
		LinkedListNode<Integer> p =head;
		LinkedListNode<Integer> q = head.next;
		
		while(q!=null) {
			LinkedListNode<Integer> temp = q.next;
			q.next = p;
			p=q;
			q=temp;
		}
		
		head.next=null;
		head=p;
		
		return head;
	}
	
    // it will ignore if extra nodes present in any of list
	public static boolean areEqual(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		
		while(l1!=null && l2!=null) {
			
			if(!l1.data.equals(l2.data))
				return false;
			
			l1=l1.next;
			l2=l2.next;
			
		}
		return true;
	}
    
    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head){
        
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next; 
            slow = slow.next;
        }
        
        return slow;
        
    }

	public static boolean isPalindrome(LinkedListNode<Integer> head1) {
        
        if(head1==null || head1.next==null)
            return true;

        LinkedListNode<Integer> res = getMid(head1);
        LinkedListNode<Integer> head2 = res.next;
		res.next = null;
		
		head2 =reverse(head2);
		
		return areEqual(head1,head2);

	}

}

class Test {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,3,2,1};
		
		LinkedListNode<Integer> head = AsList(a);
		print(head);
		boolean res = Solution.isPalindrome(head);
		System.out.println(res);
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
