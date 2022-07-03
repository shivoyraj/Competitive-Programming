// two sorted array a[] and b[]
// size of a = (m+n) first mth filled with sorted numbers
// size of b = n
// merge b[] in a[] final result should also sorted

// two sorted array a[] and b[]
// size of a = (m+n) first mth filled with sorted numbers
// size of b = n
// merge b[] in a[] final result should also sorted

class Solution {

	public void merge(int[] a1, int m, int[] a2, int n) {
		int i = m - 1, j = n - 1, k = n + m - 1;
		while (i >= 0 && j >= 0) {
			if (a1[i] > a2[j])
				a1[k--] = a1[i--];
			else
				a1[k--] = a2[j--];
		}
		while (i >= 0)
			a1[k--] = a1[i--];
		while (j >= 0)
			a1[k--] = a2[j--];
	}
}

public class Test {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 0, 0, 0 };
		int[] b = { 2, 5, 6 };
		new Solution().merge(a, 3, b, 3);
		for (int i : a)
			System.out.print(i + " ");
	}

// use below code if two input arrays are given and task in to create new array sum is equal of their size and add elements of both into new array in a sorting order sorted order

//public static int[] merge(int arr1[], int a2[]) {
//        
//        int l1 = arr1.length;
//        int l2 = a2.length;
//        
//        int[] a1 = new int[l1+l2];
//        
//        int m = l1 , n=l2;
//        
//
//		
//		for(int i=0;i<l1;i++)
//			a1[i]=arr1[i];
//        
//		int i = m - 1, j = n - 1, k = n + m - 1;
//		while (i >= 0 && j >= 0) {
//			if (a1[i] > a2[j])
//				a1[k--] = a1[i--];
//			else
//				a1[k--] = a2[j--];
//		}
//		while (i >= 0)
//			a1[k--] = a1[i--];
//		while (j >= 0)
//			a1[k--] = a2[j--];
//		
//    	return a1;
//    }
}


