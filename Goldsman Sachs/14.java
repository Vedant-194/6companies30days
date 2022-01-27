class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        
        int start = 0, end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (end < nums.length && start <= end  ) {
            sum = sum + nums[end];
            while(sum >= target)
            {
                length = Math.min(length, end - start + 1);
                sum -= nums[start++];
            }
            end++;

            }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
