public int minSwaps(int[][] g) {
        int[] res = new int[g.length];
        int idx = 0;
        for(int[] r : g) {
            int count = 0;
            for(int i = r.length-1; i >= 0; i--) {
                if(r[i] != 0) break;
                count++;
            }
            res[idx++] = count;
        }
        
        int ans = 0;
        for(int i = 0; i < g.length -1; i++) {
            int t = g.length - i - 1;
            if(res[i] >= t) continue;
            int j = i + 1;
            while(j < g.length && res[j] < t) j++;
            if(j == g.length) return -1;
            ans += j-i;
            while(j > i) {
                int z = res[j];
                res[j] = res[j-1];
                res[j-1] = z;
                j--;
            }
        }
        return ans;
    }
