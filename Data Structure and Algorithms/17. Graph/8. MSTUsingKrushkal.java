import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	
	int v1;
	int v2;
	Integer w;
	
	public Edge(int v1, int v2, Integer w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w.compareTo(o.w);
	}
    
    @Override
    public String toString(){
        return Math.min(v1,v2)+" "+Math.max(v1,v2)+" "+w;
    }
}

class Solution{
	
	private static int findParent(int v,int[] parent) {
		if(parent[v]==v)
			return v;
		return findParent(parent[v],parent);
	} 
	
	public static void Kruskal(Edge[] edges, int V , int E) {
		
		Arrays.sort(edges);
		
		int[] parent = new int[V];
		Edge[] mst = new Edge[V-1];
		
		for(int i = 0; i<V ;i++)
			parent[i] = i;
		
		int i = 0 , j = 0;
		while(i!=V-1) {
			Edge edge = edges[j++];
			int p1 = findParent(edge.v1,parent);
			int p2 = findParent(edge.v2,parent);
			if(p1!=p2) {
				mst[i] = edge;
				parent[p1] = p2;
				i++;
			}
		}
				
		for(Edge e : mst) 
            System.out.println(e);
	}
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		Edge[] edges = new Edge[E];
		
		for(int i=0;i<E;i++) {
        	int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			edges[i] = new Edge(v1,v2,w);
		}
		Kruskal(edges,V,E);
	}
}