#bellman ford algorithm
class graph:
	def __init__(self,n,m):
		self.n=n
		self.m=m
		self.edge=[]
	def addEdge(self,u,v,w):
		self.edge.append([u,v,w])
	def bellman(s):
		dist=[99999]*self.n
		dist[s]=0
		for i in range(self.n-1):
			for u,v,w in self.edge:
				dist[v]=min(dist[v],dist[u]+w)
		neg_cycle=False
		for u,v,w in self.edge:
			if dist[v]<dist[u]+w :
				neg_cycle=True
				break
		if neg_cycle:
			print ("Negative cycle exists")
		else:
			print (dist)
n,m=map(int,input().split(" "))
g=graph(n,m)
for i in range(m):
	a,b,cost=map(int,input().split(" "))
	g,addEdge(a,b,cost)
g.bellman(0)