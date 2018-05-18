/*package whatever //do not write package name here */

import java.util.*;
class graph{
    int edges[][];
    int m,n;
    @SuppressWarnings("unchecked")
      graph(int n,int m){
        this.n=n;
        this.m=m;
        edges= new int[2*m][3];
    }
    public void addEdges(int e[][]){
        for(int i=0;i<e.length;i++){
            for(int j=0;j<3;j++){
                edges[i][j]=e[i][j];
            }
        }
    }
    public void shortestPath(int a,int b){
        int dist[]=new int[n];
        Arrays.fill(dist,999999);
        dist[a]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<edges.length;j++){
                dist[edges[j][2]]=Math.min(dist[edges[j][2]],dist[edges[j][0]]+edges[j][1]);
            }
        }
        if(dist[b]<999999){
        System.out.println("YES\n"+dist[b]);
        }
        else
        System.out.println("NO");
    }
}
class NumberTriples {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
		int n=-1;
		int edges[][] = new int[2*m][3];
		int k=0;
		for(int i=0;i<m;i++){
		    int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
		    edges[k]= new int[]{x-1,y,z-1};
		    edges[k+1]=new int []{z-1,y,x-1};
		    k+=2;
		    n=Math.max(n,Math.max(x,z));
		}
		graph g = new graph(n,m);
		g.addEdges(edges);
		g.shortestPath(a-1,b-1);
	}
}