import java.util.ArrayList;
import java.util.List;

class Node {

	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class Solution {

	public static Node copyRandomList(Node head) {

        if(head==null)
            return null;

		Node p = head;
		
		//creating a duplicate node and keep add it to current node
		while (p != null) {
			
			Node temp = p.next;
			p.next = new Node(p.val);;
			p.next.next = temp;
			p = p.next.next;
			
		}

		p = head;
		
		//assigning new random pointers (located at next to random pointer) to each newly duplicated node
        while(p!=null && p.next!=null){
            
            if(p.random!=null)
                p.next.random = p.random.next;
            
            else
                p.next.random = null;
            
            p=p.next.next;
        }
        
		p = head;
		Node newHead = p.next;
		Node q = newHead;
		
		// Splitting new duplicated nodes with original node
		while(q!=null && q.next!=null) {
			
			p.next = q.next;
			q.next = p.next.next;
			
			p=p.next;
			q=q.next;

		}
		p.next=null;
		
		return newHead;
	}

}

public class test {

	public static void main(String[] args) {

		int[] a = { 7, -1, 13, 0, 11, 4, 10, 2, 1, 0 };

		Node head = createList(a);
		print(head);
		head = Solution.copyRandomList(head);
		print(head);
	}

	public static void print(Node head) {

		while (head != null) {
			if (head.random != null)
				System.out.print("[" + head.val + " " + head.random.val + "]");
			else
				System.out.print("[" + head.val + " " + "null" + "]");
			head = head.next;
		}
		System.out.println();
	}

	public static Node createList(int[] a) {

		if (a.length == 0)
			return null;

		Node head = new Node(-1);
		Node p = head;

		List<Node> list = new ArrayList<>();

		for (int i = 0; i < a.length - 1; i = i + 2) {
			p.next = new Node(a[i]);
			list.add(p.next);
			p = p.next;
		}

		p = head.next;
		for (int i = 1; i < a.length; i = i + 2) {
			if (a[i] == -1)
				p.random = null;
			else
				p.random = list.get(a[i]);
			p = p.next;
		}

		return head.next;
	}
}
