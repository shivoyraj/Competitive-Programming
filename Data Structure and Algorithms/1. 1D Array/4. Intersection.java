class Solution {

	public static void intersections(int arr1[], int arr2[]) {

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.print(arr1[i] + " ");
					arr2[j] = Integer.MIN_VALUE;
					break;
				}
			}
		}
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = { 2, 2, 1, 1, 2, 1, 0, 0, 1, 2, 2 };
		int[] b = {4,3,1,2,5};
		
		Solution.intersections(a,b);

	}
}