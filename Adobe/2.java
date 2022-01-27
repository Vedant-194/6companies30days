import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


class Solution {
    int lengthOfLongestAP(int nums[], int n) {
       int ans = 0;
       if(n == 1) 
            return 1;

        int dp[][] = new int[10001][10001];
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                int d = nums[j] - nums[i];

                dp[j][d] = Math.max(dp[i][d] + 1, 2);

                ans = Math.max(ans, dp[j][d]);
            }
        }

        return ans;
    }
}
