class Solution1{

	public static int power(int x, int n) {
        
        if(n==0)
            return 1;
        
        return x*power(x,n-1);
		
	}
}

class Solution2{
    
    static int power(int n,int p){
        
        if(p==0)
            return 1;
        
        if(p==1)
            return n;
        
        int x = power(n,p/2);
        
        if(p%2==0)
            return x*x;
            
        return x*x*n;
    }
 
}

// answers can be very large Now print the result modulo 10^9 + 7

class Solution{
    
    static long m = 1000000007;
    
    static long pow(int n,int p){
        
        if(p==0)
            return 1;
        
        if(p==1)
            return n;
        
        long x = pow(n,p/2)%m;
        
        if(p%2==0)
            return (x*x)%m;
            
        return (((x*x)%m)*n)%m;
    }
    
    long power(int n,int p){
       
       return pow(n,p)%1000000007 ;
        
    }

}