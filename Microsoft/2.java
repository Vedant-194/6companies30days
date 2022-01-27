import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
class Solution {
    
    boolean res=false;
    public boolean isPossible(int n, int[][] arr)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int[] e:arr) {
            int u=e[1];
            int v=e[0];
            adj.get(u).add(v);
        }
        isCycle(adj,n);
        return (!res);
    }
    
    
    public void isCycle(ArrayList<ArrayList<Integer>> adj,int v) {
        boolean[] vis=new boolean[v];
        boolean[] rec=new boolean[v];
        for(int i=0;i<v;i++) {
            if(!vis[i])
                dfs(adj,vis,rec,i);
        }
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,
        boolean[] rec,int u) {
        
        vis[u]=true;
        rec[u]=true;
        for(int v:adj.get(u)) {
            if(!vis[v]) {
                dfs(adj,vis,rec,v);
            } else {
                if(rec[v])
                    res=true;
            }
        }
        rec[u]=false;
    }
}
