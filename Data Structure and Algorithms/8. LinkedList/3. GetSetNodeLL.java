class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	// indexing start with 0
	public static Integer getIthNode(LinkedListNode<Integer> head, int i){

        int index = 0;
        
        while(index!=i && head!=null){
            head = head.next;
            index++;
        }
        
        if(head!=null)
 	       return head.data;
        
        else
        	return null;
	}
	
	// indexing start with 0
	public static boolean setIthNode(LinkedListNode<Integer> head, int index,int val){

        int i = 0;
        
        while(index!=i && head!=null){
            head = head.next;
            i++;
        }
        
        if(head!=null) {
 	       head.data = val;
 	       return true;
        }
        
        else
        	return false;
	}

}

class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		System.out.println(Solution.setIthNode(head, -1, 1997));
		print(head);
		System.out.println(Solution.setIthNode(head, 5, 1997));
		print(head);
		System.out.println(Solution.setIthNode(head, 12, 1997));
		print(head);
		
		System.out.println("index of -3 => "+Solution.getIthNode(head,-3));
		System.out.println("index of 7 => "+Solution.getIthNode(head,7));
		System.out.println("index of 15 => "+Solution.getIthNode(head,15));
		
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
