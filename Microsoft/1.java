import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}
class Solution
{
public int minDifference(int arr[], int n) 
{ 
     int sum=0;
      for(int i=0;i<n;i++){
          sum+=arr[i];
      }
      
      boolean dp[][] = new boolean[n+1][sum+1];
      
      for(int i=0;i<n+1;i++){
          for(int j=0;j<sum+1;j++){
              if(i==0){
                  dp[i][j]=false;
              }
              if(j==0){
                  dp[i][j]=true;
              }
          }
      }
      
      for(int i=1;i<n+1;i++){
          for(int j=1;j<sum+1;j++){
              
              if(arr[i-1]<=j){
                  dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
              }
              else{
                  dp[i][j] = dp[i-1][j];
              }
          }
      }
      
      int s1=0;
      for(int i=0;i<=sum/2;i++){
          if(dp[n][i] == true){
              s1=i;
          }
      }
      
      return sum-(2*s1);
} 
}
