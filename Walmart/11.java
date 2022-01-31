class Solution {
   static int SPD=0, EFF=1;
    public int maxPerformance(int n, int[] sp, int[] ef, int k) {
        int[][] eng= new int[n][];
        for(int i=0; i<n; i++) eng[i]= new int[]{sp[i], ef[i]};
        Arrays.sort(eng, (a,b)->b[EFF]-a[EFF]);
        PriorityQueue<Integer> team= new PriorityQueue<>();
        long speed= eng[0][SPD], perf= speed*eng[0][EFF], maxPerf= perf;
        team.add(eng[0][SPD]);
        for(int i=1; i<n; i++){
            int[] cand= eng[i];
            speed+= cand[SPD] - (team.size()==k ? team.remove() : 0);
            team.add(cand[SPD]);
            perf= speed*cand[EFF];
            if(perf>maxPerf) maxPerf= perf;
        }
        return (int)(maxPerf%1_000_000_007);
    }
}
