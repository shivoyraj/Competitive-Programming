class Solution {
    
    public static int lastIndex(int input[],int x,int i) {
        
        if(i==-1 || input[i]==x)
            return i;
        
        return lastIndex(input,x,i-1);
	}
		
	public static int lastIndex(int input[],int x) {
		return lastIndex(input,x,input.length-1);
	}
	
}