class Stack {

	private int size;
	private int tos = -1;

	Integer[] stack;

	public Stack(int size) {
		this.size = size;
		stack = new Integer[size];
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {

		if (tos == -1)
			return true;
		else
			return false;

	}

	public boolean isFull() {

		if (tos == size - 1)
			return true;
		else
			return false;
	}

	public int getTos() throws Exception {

		if (isEmpty())
			throw new Exception("Stack is Empty");

		return stack[tos];

	}

	public void push(int n) throws Exception {

		if (isFull())
			throw new Exception("Stack is Full");

		else
			stack[++tos] = n;

	}

	public int pop() throws Exception {

		if (isEmpty())
			throw new Exception("Stack is Empty");

		int val = stack[tos];
		stack[tos--] = null;

		return val;
	}

	public void print() {

		if (isEmpty())
			System.out.println("Stack is Empty");

		else {
			for (int i = 0; i < size && this.stack[i] != null; i++)
				System.out.print(this.stack[i] + " ");

			System.out.print(" <- TOS\n");
		}
	}

}

class test1 {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack(5);
		s.print();
		System.out.println("size = " + s.getSize());
		s.push(3);
		s.print();
		s.push(4);
		s.print();
		s.push(1);
		s.print();
		s.push(6);
		s.print();
		s.push(9);
		s.print();
		System.out.println(s.pop());
		s.print();
		System.out.println(s.pop());
		s.print();
		System.out.println(s.pop());
		s.print();
		System.out.println(s.pop());
		s.print();
		System.out.println(s.pop());
		s.print();
		System.out.println(s.pop());

	}

}