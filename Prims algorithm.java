// O(n^2) solution
import java.io.*;
import java.util.*;
class prims{
    private int graph[][];
    private boolean visited[];
    private int n;
    prims(int n){
        this.n=n;
        graph=new int[n][n];
         visited=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=-1;
            }
        }
    }
   void addedge(int s,int d,int r){
       if(graph[s][d]==-1){
           graph[s][d]=r;
           graph[d][s]=r;
       }
       else{
           if(r<graph[s][d]){
               graph[s][d]=r;
               graph[d][s]=r;
           }
       }
   }
   void print(int parent[]){
       int sum=0;
       for(int i=1;i<n;i++)
           sum+=graph[i][parent[i]];
       System.out.println(sum);
   }
   int minkey(int key[]){
       int min=Integer.MAX_VALUE;
       int min_index=-1;
       for(int i=0;i<n;i++){
           if(key[i]<min&&visited[i]==false)
           {
               min_index=i;
               min=key[i];
           }
       }
       return min_index;
   }
   void mst(){
       int parent[]=new int[n];
       int key[]=new int[n];
       for(int i=0;i<n;i++){
           key[i]=Integer.MAX_VALUE;
       }
       key[0]=0;
       parent[0]=-1;
       for(int i=0;i<n-1;i++){
           int current=minkey(key);
          visited[current]=true;
           for(int j=0;j<n;j++){
               if(graph[current][j]!=-1&&visited[j]==false&&graph[current][j]<key[j]){
                   parent[j]=current;
                   key[j]=graph[current][j];
               }
           }
       }
       print(parent);
   }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        int edges=sc.nextInt();
        prims p=new prims(vertices);
        for(int i=0;i<edges;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int r=sc.nextInt();
            p.addedge(s-1,d-1,r);
        }
        p.mst();
    }
}
