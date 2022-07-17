class Solution {
    
	public static void print(int n){
		
        if(n>1)
            print(n-1);
        
        System.out.print(n+" ");
	}
        
}
