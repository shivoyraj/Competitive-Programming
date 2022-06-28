class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	// will return null if n not found in list
    public static Integer indexOf(LinkedListNode<Integer> head, int n) {
        
        int pos = 0;
        LinkedListNode<Integer> p = head;
        
        while(p!=null){
            
            if(p.data.equals(n))
                return pos;
            
            pos++;
            p=p.next;
        }
        
        return null;
	}

	public static int indexOfRec(LinkedListNode<Integer> head, int n) {
		
		if(head==null)
			return -1;		
		
		if(head.data==n)
			return 0;		
		
		int res =  indexOfRec(head.next,n);
		
		if(res==-1)
			return res;
		
		return 1+res;
		
	}
    
}

class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		
		System.out.println("index of 6 => "+Solution.indexOf(head, 6));
		System.out.println("index of 17 => "+Solution.indexOf(head, 17));
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
