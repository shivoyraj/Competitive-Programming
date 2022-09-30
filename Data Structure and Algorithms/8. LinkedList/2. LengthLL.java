class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}

class Solution {
	
	public static int lengthofLL(LinkedListNode<Integer> head){

        int count =0;
        
        while(head!=null){
            head=head.next;
            count++;
        }
        
        return count;
	}

}

class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9};

		LinkedListNode<Integer> head = createList(a);
		print(head);
		System.out.println(Solution.lengthofLL(head));;

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