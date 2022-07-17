class solution {
	
	public static int[][] subsets(int input[],int sIndex) {
		
		int n = input.length;
		
		if(sIndex==n-1)
			return new int[][] {{input[n-1]}};
		
		int[][] res1 = subsets(input,sIndex+1);
		int[][] res2 = new int[2*res1.length+1][];
		
		int k =0;
		for(int i=0;i<res1.length;i++)
			res2[k++] = res1[i];
		
		res2[k++] = new int[] {input[sIndex]};
		
		for(int i=0;i<res1.length;i++,k++) {
			res2[k] = new int[res1[i].length+1];
			res2[k][0] = input[sIndex];
			for(int j=0;j<res1[i].length;j++)
				res2[k][j+1] = res1[i][j];
		}
		
		return res2;
	}
    
	public static int[][] subsets(int input[]) {
		return subsets(input,0);
	}
	
}


class Test {

	public static void main(String[] args) {

		int[] a = {1,2,3};
		int[][] res = solution.subsets(a);

		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++)
				System.out.print(res[i][j]);
			System.out.println();
		}
	}
}
