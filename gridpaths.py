def gridPaths(lookup,n,m):
	if str([n,m]) in lookup.keys():
		return lookup[str([n,m])]
	if n==0 or m==0:
		value=1
	else:
		value = gridPaths(lookup,n-1,m)+gridPaths(lookup,n,m-1)
	lookup[str([n,m])]=value
	return value

lookup=dict()
print ("enter n,m")
n,m=map(int,input().split(" "))
holes=int(input("enter number of holes"))
print ("enter coordinates for %d holes" %holes)
for i in range(holes):
	h=[int(x) for x in input().split(" ")]
	lookup[str(h)]=0
print (gridPaths(lookup,n,m))
