import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static Boolean[] isPrime;
	static List<Integer> prime = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		seive(n);
		for (Integer i : prime)
			System.out.println(i + " ");

	}

	public static void seive(int n) {

		isPrime = new Boolean[n + 1];

		for (int i = 0; i < isPrime.length; i++)
			isPrime[i] = true;

		int i = 2;
		while (i <= n) {
			if (isPrime[i]) {
				prime.add(i);
				int j = i * i;
				while (j <= n) {
					isPrime[j] = false;
					j = j + i;
				}
			}
			i++;
		}
	}

}
