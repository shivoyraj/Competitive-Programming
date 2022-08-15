import java.util.ArrayList;

class Heap{

	private ArrayList<Integer> heap;

	public Heap() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty())
			throw new PriorityQueueException("");
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int c = heap.size() - 1;
		int p = (c - 1) / 2;

		while (c > 0) {
			if (heap.get(c) < heap.get(p)) {
				int temp = heap.get(c);
				heap.set(c, heap.get(p));
				heap.set(p, temp);
				c = p;
				p = (c - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{
				
		if(heap.size()<1)
			throw new PriorityQueueException("");
		
        int x=heap.get(0), i=0, l=1, r=2;
		while(l<heap.size()) {
            
            int j = -1;
            if(r<heap.size() && heap.get(r)<heap.get(l))
				j=r;
			else
				j=l;
            
            int tmp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j,tmp);
            i=j;
            l=2*i+1;
			r=2*i+2;
		}
        heap.remove(i);
		return x;
	}
}

class PriorityQueueException extends Exception {
	public PriorityQueueException(String msg){
        super(msg);
    }
}