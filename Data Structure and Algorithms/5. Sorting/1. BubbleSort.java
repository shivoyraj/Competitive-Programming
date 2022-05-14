class Solution {

    public static void bubbleSort(int[] a){
		
        int i, j, temp;
        int n = a.length-1;
        boolean isSwapped=false;
        
        for (i = 0; i < n ; i++)
        {
            for (j = 0; j < n-i; j++)
            {
                if (a[j] > a[j + 1])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSwapped = true;
                }
            }
 
            if (isSwapped == false)
                break;
        }
    }

}


public class Test {
	public static void main(String[] args) {
		int[] a = { 8, 4, 2, 45, -3, 5, -54, 9, 5, 0 };
		new Solution().bubbleSort(a);
		for (int i : a)
			System.out.print(i + " ");
	}
}


