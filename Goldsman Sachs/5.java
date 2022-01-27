import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
       long dp[]=new long[n+1];
       dp[1]=1;
       int ptr1=1;
       int ptr2=1;
       int ptr3=1;
       for(int i=2;i<=n;i++)
       {
           long val1=dp[ptr1]*2;
           long val2=dp[ptr2]*3;
           long val3=dp[ptr3]*5;
           long min=Math.min(val1,Math.min(val2,val3));
           dp[i]=min;
           //agr same number ko ptr many ptrs thne mtlb ki next ugy number ko dhoondo else 
           //duplicacy hp jaegi
           if(min==val1)
           ptr1++;
           if(min==val2)
           ptr2++;
           if(min==val3)
           ptr3++;
       }
       return dp[n];

    }
}
