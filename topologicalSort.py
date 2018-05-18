#topological sort DAG
class graph:
	def __init__(self,n,m):
		self.n=n
		self.m=m
		self.topo=[]
		self.adj=[]
		for i in range(self.n):
			self.adj.append([])
	def addEdge(self,a,b):
		self.adj[a].append(b)
	def topologicalSort(self):
		indegree=[0]*self.n
		for i in range(self.n):
			for j in self.adj[i]:
				indegree[j]+=1 
		q=[]
		for i in range(self.n):
			if indegree[i]==0:
				q.append(i)
		while len(q)>0:
			s=q.pop(0)
			self.topo.append(s)
			for i in self.adj[s]:
				indegree[i]-=1
				if indegree[i]==0:
					q.append(i)
		print (self.topo) 

n,m=map(int,input().split(" "))
g = graph(n,m)
for i in range(m):
	a,b=map(int,input().split(" "))
	g.addEdge(a,b)
g.topologicalSort()