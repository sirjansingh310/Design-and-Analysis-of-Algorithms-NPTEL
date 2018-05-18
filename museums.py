#roads and museums
import sys
sys.setrecursionlimit(1000000)#or do bfs :p
class graph:
	def __init__(self,n,m,k):
		self.n=n
		self.m=m
		self.k=k
		self.museums =[0]*self.n
		self.visited=[False]*self.n
		self.adj = []
		for i in range(n):
			self.adj.append([])
	def addEdge(self,a,b):
		self.adj[a].append(b)
		self.adj[b].append(a)
	def setMuseums(self,museums):
		self.museums = museums
	def dfs(self,i):
	    c=self.museums[i]
	    self.visited[i]=True 
	    for i in self.adj[i]:
	        if self.visited[i]==False:
	            c+=self.dfs(i)
	    return c
	def dfsUtil(self):
		c = []
		for i in range(self.n):
			if self.visited[i] == False:
				k = self.dfs(i)
				c.append(k)
		if len(c) < self.k:
			print (-1)
			return 
		else:
			#print (c)
			res =0
			left = 0
			c.sort()
			right = len(c)-1
			for i in range(self.k):
			    if i%2 == 0:
			        res+=c[right]
			        right-=1
			    else:
			        res +=c[left]
			        left+=1 
			print (res)

n,m,k=map(int,input().split(" "))
g= graph(n,m,k)
for i in range(m):
	a,b=map(int,input().split(" "))
	g.addEdge(a-1,b-1)
museums=[int(x) for x in input().split(" ")]
g.setMuseums(museums)
g.dfsUtil()