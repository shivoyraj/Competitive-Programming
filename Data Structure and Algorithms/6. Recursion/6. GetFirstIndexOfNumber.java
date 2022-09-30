class Solution {
    
	public static int firstIndex(int input[],int i, int x) {
	   
        if(i==input.length)
           return -1;
        
        if(input[i]==x)
            return i;
        
        return firstIndex(input,i+1,x);
	}

	public static int firstIndex(int input[], int x) {        
        return firstIndex(input,0,x);
	}
	
}