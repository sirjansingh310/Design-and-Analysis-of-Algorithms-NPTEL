#bfs program in python
class Graph:
    def __init__(self,n):
        self.n=n
        self.visited=[False]*(self.n)
        self.linkedlist=[]
        for i in range(n):
            self.linkedlist.append([])
        
    def addEdge(self,u,v):
        self.linkedlist[u].append(v)
        self.linkedlist[v].append(u)
    def bfs(self,start):
        queue=[]
        queue.append(start)
        self.visited[start]=True
        while(len(queue)>0):
            current=queue.pop(0)#pop the first element !
            print(str(current)+" ", end="")
            for i in self.linkedlist[current]:
                if self.visited[i]==False:
                    queue.append(i)
                    self.visited[i]=True
    
n=int(input("Enter number of nodes:"))
m=int(input("Enter number of edges:"))
g=Graph(n)#n and m are already global
for i in range(m):
    print("Enter edge")
    a,b=map(int,input().split(' '))
    g.addEdge(a,b)

g.bfs(0)
