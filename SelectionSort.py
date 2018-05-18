#selection sort program
def selectionSort(a):
	for i in range(len(a)):
		minpos=i
		for j in range(i+1,len(a)):
			if a[j]<a[minpos]:
				minpos=j
		swap(a,i,minpos)

def swap(a,i,j):
	a[i],a[j]=a[j],a[i]
	
print ("Enter array Elements")
arr=[int(x) for x in input().split(" ")]
selectionSort(arr)
print ("Sorted array ->",arr)
