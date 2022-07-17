class Solution {
    
    public static void swap(int[] a,int i,int j) {
		
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
	
	public static int getPivotPosition(int[] a,int l,int h) {
		
		int p =l;
		
		while(l<h) {
			
			do{
				l++;
			}
            while(l<a.length && a[l]<=a[p]);
	
			do{
				h--;
			}
			while(h>=0 && a[h]>a[p]);
						
			if(l<h)
				swap(a,l,h);			
		}
		swap(a,p,h);
		
		return h;
	}
	
	public static void quickSort(int[] a,int l,int h){
		
		if(l<h) {
			int pvt = getPivotPosition(a,l,h);	
			quickSort(a,l,pvt);
			quickSort(a,pvt+1,h);
		}
		
	}
	
	public static void quickSort(int[] input) {
        quickSort(input,0,input.length);
	}
	
}