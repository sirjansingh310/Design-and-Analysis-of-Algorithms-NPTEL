#quick sort in python
#http://interactivepython.org/runestone/static/pythonds/SortSearch/TheQuickSort.html
def swap(arr,i,j):
	arr[i],arr[j]=arr[j],arr[i]  

def partition(a,low,high):
	pivot=a[low]
	left=low+1
	right=high
	while True:
		while left<=right and a[left]<=pivot:
			left+=1
		while right>=left and a[right]>pivot:
			right-=1
		if right<left:
		    break
		swap(a,left,right)
	swap(a,low,right)
	return right
def quickSort(arr,low,high):
	if high<=low:
		return
	m=partition(arr,low,high)
	quickSort(arr,low,m-1)
	quickSort(arr,m+1,high)

print ("Enter elements of array")
arr=[int(x) for x in input().split(" ")]
quickSort(arr,0,len(arr)-1)
print ("Sorted array ->",arr)
