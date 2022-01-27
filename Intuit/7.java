class Solution {
    public int shipWithinDays(int[] w, int d) {
        int l = 0;
        int r = 0;
        int mid = 0;
        for(int i = 0; i < w.length; i++){
            l = Math.max(l,w[i]);
            r += w[i];
        }
        while(l < r){  
            int count = 1;
            mid = (l+r) >> 1; 
            int sum = 0;
            for(int i = 0; i < w.length; i++){
                if(sum + w[i] <= mid){
                    sum += w[i];
                }else{
                    count += 1;
                    sum = w[i];
                }            
            }
            if(count <= d){
                r = mid;
            }else{
                l = mid +1;
            }
        }
        return l; 
    }
}
