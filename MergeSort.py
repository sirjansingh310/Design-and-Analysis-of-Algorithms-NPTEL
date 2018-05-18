#merge sort program 
def Merge(L,m,R,n,C):
        i=0
        j=0
        k=0
        while(k<m+n):
                if(i==m):
                        C[k]=R[j]
                        k+=1
                        j+=1
                elif(j==n):
                        C[k]=L[i]
                        k+=1
                        i+=1
                elif(L[i]<=R[j]):
                        C[k]=L[i]
                        i+=1
                        k+=1
                elif(L[i]>R[j]):
                        C[k]=R[j]
                        k+=1
                        j+=1


def MergeSort(A,left,right,B):
        if(right-left == 1):
                B[0]=A[left]
        else:
                mid=(left+right)//2
                L=[0]*(mid-left)
                R=[0]*(right-mid)
                MergeSort(A,left,mid,L)
                MergeSort(A,mid,right,R)
                Merge(L,mid-left,R,right-mid,B)

print("Enter the elements of array which needs to be sorted")
arr=[int(x) for x in input().split(" ")]
B=[0]*len(arr)
MergeSort(arr,0,len(arr),B)
print("The sorted values are",B)
