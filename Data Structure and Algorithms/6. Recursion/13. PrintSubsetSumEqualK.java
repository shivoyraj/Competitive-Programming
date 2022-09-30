class solution {
	
	public static void printSubsetsSumTok(int input[], int k,int i,String s) {
		
		if(k<=0 || i==input.length){
			if(k==0)
				 System.out.println(s.trim());
			 return;
		 }
		
		printSubsetsSumTok(input,k - input[i], i + 1, s+" "+input[i]);
		printSubsetsSumTok(input,k, i + 1, s);

	}
	
	public static void printSubsetsSumTok(int input[], int k) {
		printSubsetsSumTok(input,k,0,"");
	}
}


class Test {

	public static void main(String[] args) {

		int[] a = {5, 12, 3, 17, 1, 18, 15, 3, 17};
		solution.printSubsetsSumTok(a,6);

	}
}
