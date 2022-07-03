class Solution {

    public static void rotate(int[] arr, int d) {
    	//Your code goes here
        int n = arr.length;
        
        if (n==0)
            return; 
        
        int mod = d % n;
 		
        int res[] = new int[n];
		
        for (int i = 0; i < n; ++i)
            res[i]=arr[(i + mod) % n];
        
        for(int i=0;i<n;i++)
            arr[i]=res[i];
        
    }
}

public class test {
	public static void main(String[] args) {

		int[] a = { 1,2,3,4,5,6,7,8,9 };

		Solution.rotate(a,6);

		for (int i : a)
			System.out.print(i + " ");

	}
}