class Solution{

    public static int digitalRoot(int n){
        
        if(n<10)
            return n;
        
        return digitalRoot(n%10 + digitalRoot(n/10));
    }
}