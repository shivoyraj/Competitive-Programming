class solution {

	public static void towerOfHanoi(int n, char source, char aux, char destination) {

        if (n == 0)
            return;
        
        towerOfHanoi(n - 1, source, destination, aux);
        System.out.println(source + " " + destination);
        towerOfHanoi(n - 1, aux,source,destination);
        
	}
}
