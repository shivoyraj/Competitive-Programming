class Solution {
    
    public static boolean checkNumber(int input[], int i, int x) {
        
        if(i == input.length)
            return false;
        
        return input[i]==x || checkNumber(input,i+1,x);
        
	}
	
	public static boolean checkNumber(int input[], int x) {
        return checkNumber(input,0,x);
	}
}