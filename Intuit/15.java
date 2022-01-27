class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high = Arrays.stream(piles).max().getAsInt();
        while(low<high)
        {
            int mid = low + (high - low) / 2 ;
            int hour = 0;
            for(int i : piles)
            {
                int rem = i%mid==0?0:1;
                hour += i/mid;
                hour += rem; 
            }
            if(hour<=h)
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }
}
