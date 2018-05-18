#all pairs shortest path: Floyd-Warshall algorithm 
class graph:
	def __init__(self,n):
		self.n=n
		self.edge=[]*self.n
		for i in range(self.n):
		    self.edge.append([0]*self.n)
		    for j in range(self.n):
		        if i == j :
		            self.edge[i][j]=0
		        else:
		            self.edge[i][j]=99999
			        
	def addEdge(self,u,v,w):
		self.edge[u][v]=w
	def shortestPaths(self):
		for k in range(self.n):
			for i in range(self.n):
				for j in range(self.n):
					self.edge[i][j]=min(self.edge[i][j],self.edge[i][k]+self.edge[k][j])
		for i in self.edge:
		    for j in i:
		        if j==99999:
		            w="INF"
		        else:
		            w=j
		        print (w,end=" ")
		    print ()

n,m=map(int,input().split(" "))
g=graph(n)
for i in range(m):
	a,b,cost=map(int,input().split(" "))
	g.addEdge(a,b,cost)
g.shortestPaths()