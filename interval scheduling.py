#interval scheduling
def getKey(item):
	return item[1]
n=int(input())
l=[]
for _ in range(n):
	a,b=map(int,input().split(" "))
	b+=a# b is time it takes to complete the task, b+a is the finish time
	l.append([a,b])
l=sorted(l,key=getKey)
#print (l)
count=1
current=l[0][1]
for i in range(1,n):
	if l[i][0]>=current:
		current=l[i][1]
		count+=1
print (count)# b is time it takes to complete the task, b+a is the finish time