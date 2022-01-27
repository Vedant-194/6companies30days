class Solution {
    public int splitArray(int[] nums, int m) {
        int maxVal = 0;
        int minVal = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            maxVal += nums[i];
            minVal = Math.max(minVal, nums[i]);
        }
        
        while(minVal < maxVal) {
            int midVal = minVal + (maxVal - minVal)/2;
            if(canSplit(midVal, nums, m)) {  
                maxVal = midVal;
            } else {  
                minVal = midVal + 1;
            }
        }
        
        return minVal;
    }
    
    private boolean canSplit(int maxSubArrSum, int[] nums, int m) {
        int currSum = 0;
        int currSplits = 1;
        
        for(int num : nums) {
            currSum += num;
            if(currSum > maxSubArrSum) {
                currSum = num;
                currSplits++;
                
                if(currSplits > m) return false;  
            }
        }
        
        return true;
    }
}
