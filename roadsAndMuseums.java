//roads and museums 
import java.util.*;
class graph{
   boolean visited[];
   LinkedList<Integer> adj[];
   int n,m,k;
   int museums[];
   ArrayList<ArrayList<Integer>> component;
         @SuppressWarnings("unchecked")
   graph(int n,int m,int k){
      this.n=n;
      this.m=m;
      this.k=k;
      visited = new boolean[n];
      adj=new LinkedList[n];
      for(int i=0;i<n;i++){
         adj[i] = new LinkedList<Integer>();
      }
      component = new ArrayList<>();
   }
   public void addEdge(int a,int b){
      adj[a].add(b);
      adj[b].add(a);
   }
   public void setMuseums(int museums[]){
       this.museums=museums;
   }
   public void dfsUtil(){
      for(int i=0;i<n;i++){
         if(!visited[i]){
            ArrayList<Integer> list = new ArrayList<Integer>();
             dfs(i,list);
             component.add(list);
         }
      }
      if(component.size()<k){
          System.out.println("-1");
          return ;
      }
      else{
          int m[] = new int[component.size()];
          int res = 0;
          for(int i=0;i<component.size();i++){
              ArrayList<Integer> list = component.get(i);
              for(int j=0;j<list.size();j++){
                  m[i]+=museums[list.get(j)];
              }
          }
          Arrays.sort(m);
          int left =0;
          int right =m.length-1;
          for(int i=0;i<k;i++){
              if(i%2==0){
                  res+=m[right];
                  right--;
              }
              else{
                  res+=m[left];
                  left++;
              }
          }
          System.out.println(res);
      }
   }
   void dfs(int a,ArrayList<Integer> list){
      visited[a]=true;
   // System.out.print(a+" ");
   list.add(a);
      Iterator<Integer> itr = adj[a].iterator();
      while(itr.hasNext()){
         int next = itr.next();
         if(!visited[next]){
            dfs(next,list);
         }
      }
   }
}
class roadsAndMuseums{
public static void main(String args[]){
       Scanner sc= new Scanner(System.in);
      int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
      graph g = new graph(n,m,k);
      for(int i=0;i<m;i++){
         int a = sc.nextInt(),b=sc.nextInt();
         g.addEdge(a-1,b-1);
      }
      int museums[] = new int[n];
      for(int i=0;i<n;i++){
         museums[i]=sc.nextInt();
      }
      g.setMuseums(museums);
      g.dfsUtil();
}
}