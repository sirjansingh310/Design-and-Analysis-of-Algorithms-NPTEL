#insertion sort
def insertionSort(a):
	for i in range(len(a)):
		prev=i
		while(prev>0 and a[prev]<a[prev-1]):
			swap(a,prev,prev-1)
			prev=prev-1
			

def swap(a,i,j):
	a[i],a[j]=a[j],a[i]

print ("Enter array Elements")
arr=[int(x) for x in input().split(" ")]
insertionSort(arr)
print ("Array after sorting ->",arr)