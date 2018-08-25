// Min Range Query using Segment Tree
// O(N) to construct tree
// O(log(N)) for single query and updatation.
import java.util.*;
class SegmentTree{
    int segtree[];
    int max = Integer.MAX_VALUE;
    int arr[];
    SegmentTree(int arr[]){
        this.arr = arr;
        int size = nextPowerOfTwo(arr.length);
        segtree = new int[2*size-1];
        Arrays.fill(segtree,max);
        constructSegmentTree(segtree,arr,0,arr.length-1,0);
    }
    public void constructSegmentTree(int segtree[],int arr[],int low,int high,int idx){
        if(low == high){
          segtree[idx] = arr[low];
          return;
        }
        else{
            int mid = (low+high)/2;
            constructSegmentTree(segtree,arr,low,mid,2*idx+1);
            constructSegmentTree(segtree,arr,mid+1,high,2*idx+2);
            segtree[idx] = Math.min(segtree[2*idx+1],segtree[2*idx+2]);
        }
    }
    public int query(int low,int high,int qlow,int qhigh,int idx){
        if(qlow<=low && qhigh>=high)
           return segtree[idx];
        if(qlow>high || qhigh< low) 
           return max;
        int mid = (low+high)/2;
        return Math.min(query(low,mid,qlow,qhigh,2*idx+1),query(mid+1,high,qlow,qhigh,2*idx+2));
    }
    public int nextPowerOfTwo(int a){
        if((a & (a-1))==0)
            return a;
        int p=1;
        while(p<a){
            p = p<<1;
        }
        return p;
    }
    public void update(int low,int high,int idx,int arrIdx, int val){
        if(low>arrIdx || high<arrIdx)
            return;
        if(low == high){
          segtree[idx] = val;
          return;
        }
        int mid = (low+high)/2;
        update(low,mid,2*idx+1,arrIdx,val);
        update(mid+1,high,2*idx+2,arrIdx,val);
        segtree[idx] = Math.min(segtree[2*idx+1],segtree[2*idx+2]);        
    }
}
class mainclass{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        SegmentTree tree = new SegmentTree(arr);
        for(int qi=0;qi<q;qi++){
             String line = sc.nextLine();
             StringTokenizer st = new StringTokenizer(line);
             String query = st.nextToken();
             int x = Integer.parseInt(st.nextToken())-1;
             int y = Integer.parseInt(st.nextToken())-1;
             if(query.equals("q"))
                System.out.println(tree.query(0,arr.length-1,x,y,0));
             if(query.equals("u"))
                {
                    arr[x] = y+1;
                    tree.update(0,arr.length-1,0,x,y+1);
                }
        }
    }
}
