#dijkstras algorithm
class graph:
	def __init__(self,n,m):
	    self.n=n
	    self.m=m
	    self.inf=99999
	    self.cost=[]
	    self.adj=[]
	    for i in range(self.n):
	        self.cost.append([0]*n)
	        self.adj.append([])
	def addEdge(self,a,b,c):
	    self.adj[a].append(b)
	    self.adj[b].append(a)
	    self.cost[a][b]=c
	    self.cost[b][a]=c
	
	def minNode(self,dist,visited):
		node = -1
		minimum=self.inf
		for i in range(self.n):
			if visited[i]==False:
				if dist[i]<minimum:
					minimum=dist[i]
					node=i
		return node
	def shortestPath(self,s):
		visited=[False]*self.n
		dist=[self.inf]*self.n
		dist[s]=0
		visited_count = 0
		while visited_count < self.n:
			minimum = self.minNode(dist,visited)
			visited[minimum]=True
			visited_count+=1 
			for i in self.adj[minimum]:
				dist[i]=min(dist[i],dist[minimum]+self.cost[i][minimum])
		print (dist)#minimum distances from s to all other vertices

n,m=map(int,input().split(" "))
g=graph(n,m)
for i in range(m):
	a,b,cost=map(int,input().split(" "))
	g.addEdge(a,b,cost)
g.shortestPath(0)