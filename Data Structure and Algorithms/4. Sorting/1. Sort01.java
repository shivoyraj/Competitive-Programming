class Solution {

	public static void sortZeroesAndOne(int input[], int size) {
		int nextZero = 0;
		for (int i = 0; i < size; i++) {
			if (input[i] == 0) {
				int temp = input[nextZero];
				input[nextZero] = input[i];
				input[i] = temp;
				nextZero++;
			}
		}
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = {1,0,0,1,1,1,0,0,1,1};

		Solution.sortZeroesAndOne(a, a.length);
		
		for(int i:a)
			System.out.print(i+" ");
		
	}
}