/* hackerrank problem
link: https://www.hackerrank.com/challenges/dijkstrashortreach
Author: Sirjan Singh
Priority Queue using heaps, O((m+n)log(n)) solution 
*/
import java.util.*;
class graph{ 
    int n;
    int heap[];
    int nodeToHeap[];
    int heapToNode[];
    int heapSize;
    int cost[][];
    LinkedList<Integer> adj[];
    graph(int n){
        this.n=n;
        heapSize=n; 
        cost= new int[n][n];
        heap=new int[n];
        adj=new LinkedList[n];
        nodeToHeap=new int[n];
        heapToNode=new int[n];
        Arrays.fill(heap,100001);
        for(int i=0;i<n;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void addEdge(int a,int b,int c){
        if(cost[a][b]==0){
            adj[a].add(b);
            adj[b].add(a);
            cost[a][b]=c;
            cost[b][a]=c;
        }
        else{
            cost[a][b]=Math.min(cost[a][b],c);
            cost[b][a]=cost[a][b];
        }
    }
    public void buildHeap(){
        for(int i=n/2 -1;i>=0;i--){
            heapify(i,heapSize);
        }
        
    }
    public void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
        temp=heapToNode[i];
        heapToNode[i]=heapToNode[j]; 
        heapToNode[j]=temp;
        temp =nodeToHeap[heapToNode[i]];
        nodeToHeap[heapToNode[i]]=nodeToHeap[heapToNode[j]];
        nodeToHeap[heapToNode[j]]=temp;

    }
    public void heapify(int i, int size){// fixing by going down
        int smallest=heap[i];
        int smallest_index=i;
        int leftChild=2*i+1; 
        int parent=i;
        int rightChild = 2*i+2;
        if(leftChild<size && heap[leftChild]<smallest){
            smallest=heap[leftChild];
            smallest_index=leftChild;
        }
        if(rightChild<size && heap[rightChild]<smallest){
            smallest=heap[rightChild];
            smallest_index=rightChild;
        }
        if(smallest!=heap[parent]){
            swap(smallest_index,parent);
            heapify(smallest_index,size);// Recursive call
        }
    }
    public void updateHeap(int index,int update){// fixing by going up
        heap[index]=update;
        int parent=(index-1)/2;
        while(heap[parent]>heap[index]){
            swap(parent,index);  
            index=parent;
            parent=(index-1)/2;
        }
    }
    public void shortestPaths(int s){
        for(int i=0;i<n;i++){
            nodeToHeap[i]=i;
            heapToNode[i]=i;
        }
        heap[s]=0; 
        buildHeap();
        for(int i=0;i<n;i++){
            int min=heap[0];
            int minNode=heapToNode[0];
            swap(0,heapSize-1);
            heapify(0,heapSize-1);
            heapSize--;
            Iterator<Integer> itr = adj[minNode].iterator();
            while(itr.hasNext()){
                int next = itr.next();
                int heap_index = nodeToHeap[next];
                int distNext=heap[heap_index];
                if(min+cost[next][minNode]<distNext){
                    distNext=min+cost[next][minNode];
                    updateHeap(heap_index,distNext);
                }
                
                
            }
        }
       for(int i=0;i<n;i++){
           if(i==s)
               continue;
           else if (heap[nodeToHeap[i]]<100001){
               System.out.print(heap[nodeToHeap[i]]+" ");
           }
           else
               System.out.print("-1"+" ");
       }        
    }
}
class Dijkstra{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            graph g = new graph(n);
            for(int i=0;i<m;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int cost = sc.nextInt();
                g.addEdge(a-1,b-1,cost);
            }
            int source = sc.nextInt();
            g.shortestPaths(source-1);
            System.out.println();
        }
    }
}