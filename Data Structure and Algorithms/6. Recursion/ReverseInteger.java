class Solution {
    
    public static int rev(int N , int n) {
		
		if(N<10)
			return n*10 + N;
		
		return rev(N/10,n*10+N%10);
	}
    
    public int reverse(int x) {
        return rev(x,0);
    }
}


// Given a signed 32-bit integer x, return x with its digits reversed. 
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

class Solution2{
    
    public static long rev(long N , long n) {
        
		if(N<10){
            long res = n*10 + N;
            if(res>=Math.pow(2,31))
                return 0;
            return res;
        }
		
		return rev(N/10,n*10+N%10);
	}
    
    public int reverse(int x) {
                        
        if(x>0)
            return (int)  rev((long)x,0);
        else
            return (int) -rev(-(long)x,0);
    }
}