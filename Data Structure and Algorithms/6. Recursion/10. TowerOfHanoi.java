// it will print steps and finally return no of steps required

class solution{

    public long destinationwerOfHanoi(int N, int source, int destination, int aux) {
        
        if(N==0)
            return 0;
        
        long n1 = destinationwerOfHanoi(N-1,source,aux,destination);
        System.out.println("move disk " +N+ " source rod "+ source+" destination rod "+destination);
        long n2 =  destinationwerOfHanoi(N-1,aux,destination,source);

        return n1+n2+1;
    }
}

