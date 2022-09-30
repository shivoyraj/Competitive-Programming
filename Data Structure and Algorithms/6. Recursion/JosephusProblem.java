import java.util.Scanner;

class Solution { 
	
    static int josephus(int n, int k){
        
		if(n==1)
            return 0;
        
        return (josephus(n-1,k)+k)%n;
    }
    
	public static void main(String[] args){ 
	    
        Scanner s =new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
        System.out.println(josephus(n,k)+1);
	}
	
}