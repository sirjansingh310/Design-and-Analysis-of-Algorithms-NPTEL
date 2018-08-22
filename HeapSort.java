//heap sort program 
//O(nlogn)
import java.util.*;
class HeapSort{
	public static void buildHeap(int a[]){
		int size = a.length;
		for(int i=size/2-1;i>=0;i--){// leaf nodes already satisfy the heap property, so no need to fix them
              heapify(a,i,size);// bottom up heapification.  heapify takes O(logn) time
		}
	}
	public static void heapify(int a[],int i,int size){// fixing by going down, i as parent 
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		int parent = i;
		// left child and right child should be present in the current heap, so we check using size 
		int largest = a[parent] ;// assume parent is largest
		int largest_index = parent;
		if(leftChild<size && a[leftChild]>largest){
			largest = a[leftChild];
			largest_index=leftChild;
		}
		if(rightChild<size && a[rightChild]>largest){
			largest = a[rightChild];
			largest_index=rightChild;
		}
		
		if (largest!=a[parent]){
		    swap(a,largest_index,parent);
			heapify(a,largest_index,size);
		}
		
	}
	public static void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void heapSortFn(int a[]){
	    int n = a.length;
		for(int i=0;i<n;i++){
			swap(a,0,n-i-1);// swap max with last elemnt of our heap, heap shrinks at each stage and max goes at last
			heapify(a,0,n-i-1);// n-i-1 is our current heap size, we check if left and right children index values are lesser than this index
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		buildHeap(a);
		heapSortFn(a);
		System.out.println("Sorted array :");
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}

	}
}
