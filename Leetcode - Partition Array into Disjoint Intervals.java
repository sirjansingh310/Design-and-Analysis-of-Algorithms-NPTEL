// https://leetcode.com/problems/partition-array-into-disjoint-intervals/
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[][] minMaxData = new int[nums.length][2]; // store max till now starting from left of array, min till now starting from right
                                                      // note for min till now: Don't include current element, as we want the partitions to be disjoint.
                                                      // ex [90,47,69,10,43,92,31,73,61,97]. ans: 9, as min till now for element 61 is 97 and not 61. 
        
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            minMaxData[i][0] = max;
        }
        
        int min = Integer.MAX_VALUE; // don't include current element as min till now, it will be considered in next itr.
        for (int i = nums.length - 1; i >= 0; i--) {
            minMaxData[i][1] = min;
            min = Math.min(nums[i], min);
        }
        
        // System.out.println(Arrays.deepToString(minMaxData));
        
        for (int i = 0; i < nums.length; i++) {
            if (minMaxData[i][0] <= minMaxData[i][1]) {
                return i + 1;
            }
        }
        return nums.length;
    }
}
