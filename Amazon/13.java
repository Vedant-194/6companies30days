class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2)
                    que.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        int l, t=0;
        int r,c;
        while(!que.isEmpty()){
            l = que.size();
            while(l>0){
                r=que.peek()[0];
                c=que.peek()[1];
                que.poll();
                
                if(r<grid.length-1 && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    fresh--;
                    que.offer(new int[]{r+1,c});
                }
                if(c<grid[0].length-1 && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    fresh--;
                    que.offer(new int[]{r,c+1});
                }
                if(r>0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    fresh--;
                    que.offer(new int[]{r-1,c});
                }
                if(c>0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    fresh--;
                    que.offer(new int[]{r,c-1});
                }
                l--;
            }
            t++;
        }
        if(fresh>0)
            return -1;
        return t-1;
    }}
