class Solution {
    Integer[][] seen;
    Integer maxx;
    public int getMoneyAmount(int n) {
        seen=new Integer[n][n];
        return find_(1,n);
    }
    
    private int find_(int s, int e){
        if (s>=e) return 0;
        if (seen[s-1][e-1]!=null) return seen[s-1][e-1];
        Integer ans=Integer.MAX_VALUE;
        for (int i=s; i<=e; i++){
            ans=Math.min(ans, i+Math.max(find_(i+1,e), find_(s,i-1)));
        }
        seen[s-1][e-1]=ans;
        return ans;
    }
}
