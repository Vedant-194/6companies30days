class Solution {
    int[] root;
    public int findCircleNum(int[][] isConnected) {
        int r = isConnected.length, c = isConnected[0].length;
        root = new int[isConnected.length];
        int num = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < root.length; i++)
            root[i] = i;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int rootx = find(i);
                int rooty = find(j);
                if(isConnected[i][j] == 1 && (i != j)){
                    root[rootx] = rooty;
                }
            }
        }
        for(int i : root){
            set.add(i);
        }
        return set.size();
    }
    
    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
}
