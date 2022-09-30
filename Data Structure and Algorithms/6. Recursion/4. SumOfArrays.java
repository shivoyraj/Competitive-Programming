class Solution {
    
    public static int sum(int input[], int i) {
        
        if(i==input.length-1)
        	return input[i];
        
        return input[i]+sum(input,i+1);   
	}

	public static int sum(int input[]) {
		return sum(input,0);   
	}
}