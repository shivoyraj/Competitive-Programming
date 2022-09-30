class Solution1 {

    public static void rotate(int[] arr, int d) {

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

class Solution2 {
    
    static void reverse(int arr[] , int i , int j){
        while(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    void rotateArr(int arr[], int d, int n){
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
}

class test {
	public static void main(String[] args) {

		int[] a = { 1,2,3,4,5,6,7,8,9 };

		Solution1.rotate(a,6);

		for (int i : a)
			System.out.print(i + " ");

	}
}