package array.setup;

class Solution {

	public static void heapSort(int arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])  // use < in case of desc order
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])  // use < in case of desc order
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
}

class test {

	public static void main(String[] args) {
		int[] m = { 95, -97, -387, -435, -5, -70, 897, 127, 23, 284 };
		print(m);
		Solution.heapSort(m);
		print(m);
	}

	public static void print(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}

}