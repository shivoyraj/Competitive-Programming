class Solution {
    
    public static boolean checkMaxHeap(int arr[], int i) {
		
        if(i >= arr.length)
            return true;
        
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if(l<arr.length && arr[i] < arr[l])
            return false;
        
        if(r<arr.length && arr[i] < arr[r])
            return false;
        
        return checkMaxHeap(arr,l) && checkMaxHeap(arr,r);
	}

	public static boolean checkMaxHeap(int arr[]) {
		return checkMaxHeap(arr,0);
	}
}