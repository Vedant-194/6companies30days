class Solution {
    public int longestMountain(int[] arr) {
        int answer = 0 ;
        if(arr.length < 2)
            return 0;
        for(int i = 1 ; i < arr.length - 1 ; i++)
        {
            boolean isPeak = false;
            if(arr[i] > arr[i+1] && arr[i] > arr[i-1])
            {
                isPeak = true;
                
            }
            if(isPeak)
            {
                int j = i-1;
                int height = 1;
                while(j >= 0 && arr[j+1] > arr[j])
                {
                    height++;
                    j--;
                }
                j = i+1;
                while(j < arr.length && arr[j-1] > arr[j])
                {
                    height++;
                    j++;
                }
                answer = Math.max(answer,height);
                
            }
        }
        return answer;
    }
}
