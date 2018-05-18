//Tree Sort program. Time complexity: O(nlogn) if the tree is balanced. Worst case: O(n^2) in case of unbalanced tree.
import java.util.*;
class Node{
	int value;
	Node left;
	Node right;
	Node(int val){
		value=val;
		left = null;
		right=null;
	}
}
class mainclass{
	public static void insert(Node k, int v ){
		if(v<k.value){
			if(k.left==null){
                k.left = new Node(v);
			}
			else
				insert(k.left,v);
		}
		else if(v>k.value){
			if(k.right==null)
				k.right=new Node(v);
			else
				insert(k.right,v);
		}
		else
			return;
	}
	public static void inorder(Node k){
		if(k==null)
			return;
		inorder(k.left);
		System.out.print(k.value+" ");
		inorder(k.right);
	}
	public static void main(String args[]){
         int a[] = {30,23,42,25,45,60,100};
         Node root = new Node(a[0]);
         for(int i=1;i<a.length;i++){
                insert(root,a[i]);
         }
         inorder(root);


	}
}