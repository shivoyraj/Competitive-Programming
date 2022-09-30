// arr[] = {0,-10,1,3,-20}
// Output: 2

class Solution {

	static int missingNumber(int[] arr, int n) {

		int i = 0;
		while (i < n) {

			int correctPos = arr[i] - 1;
			if (arr[i] > 0 && arr[i] < n && arr[i] != arr[correctPos]){
			    int temp = arr[i];
		        arr[i] = arr[correctPos];
		        arr[correctPos] = temp;
			}
			else
				i++;
		}

		for (i = 0; i < n; i++)
			if (i!=arr[i]-1)
				return i + 1;

		return i + 1;
	}
}