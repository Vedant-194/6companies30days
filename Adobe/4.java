// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0 ; i<N ; i++){
            sum = sum + arr[i];
        }
        if(sum % 2 != 0)
            return 0;
        else
            return isSubsetSum(arr , sum/2 , N);
    }
    static int isSubsetSum(int arr[] , int sum , int n){
        
        int dp[][] = new int[n+1][sum+1];
        
        for(int i=0 ; i<n+1 ; i++){
            for(int j=0 ; j<sum+1 ; j++){
                
                if(i==0)
                    dp[i][j] = 0;
                
                if(j == 0)
                    dp[i][j] = 1;
            }
        }
        for(int i=1 ; i<n+1 ; i++){
            for(int j=1 ; j<sum+1 ; j++){
                
                if(arr[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
