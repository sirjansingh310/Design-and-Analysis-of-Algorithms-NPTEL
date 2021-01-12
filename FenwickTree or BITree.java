/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class BITree {
    private int bitTree[];
    private int originalArray[];
    
    BITree(int arr[]) {
        this.originalArray = Arrays.copyOf(arr, arr.length);
        bitTree = new int[originalArray.length + 1]; // 0 node is dummy node. 
        
        //O(nlogn) for creating the BIT Tree. We call update method, initial value of tree is 0s
        for(int i = 0; i < originalArray.length; i++) {
            updateTree(i + 1, 0, originalArray[i]);
        }
    }
    
    public int getPrefixSum(int index) {
        int sum = 0;
        index++; // node 0 is dummy node. for sum of originalArray[0, x] , we should start calculating sum 
        // from x + 1 index of bitTree
        
        while (index > 0) {
            sum += bitTree[index];
            index = getParent(index);
        }
        
        return sum;
    }
    
    public int getRangeSum(int start, int end) {
        return getPrefixSum(end) - getPrefixSum(start - 1);
    }
    
    public void updateArray(int index, int newValue) {
        updateTree(index + 1, originalArray[index], newValue);
        originalArray[index] = newValue;
    }
    
    private void updateTree(int bitTreeIndex, int oldValue, int newValue) {
        // logN opearation to update 
        int difference = newValue - oldValue;
        
        while (bitTreeIndex < bitTree.length) {
            bitTree[bitTreeIndex] += difference;
            bitTreeIndex = getNextIndex(bitTreeIndex);
        }
    }
    
    private int getNextIndex(int index) {
        return index + (index & -index); // number = number + (number & 2sComplement of number)
    }
    
    private int getParent(int index) {
        return index - (index & -index);
    }
}
class GFG {
	public static void main (String[] args) {
		BITree tree = new BITree(new int[]{1, 2, 3});
		
		System.out.println(tree.getPrefixSum(2)); // 6
		System.out.println(tree.getPrefixSum(1));// 3
		System.out.println(tree.getPrefixSum(0)); // 1
		
		tree.updateArray(2, 12);// arr-> 1, 2, 12
		
		System.out.println(tree.getPrefixSum(2)); // 15
		System.out.println(tree.getPrefixSum(1));// 3
		System.out.println(tree.getPrefixSum(0)); // 1
		
		System.out.println(tree.getRangeSum(1, 2));//14
	}
}
