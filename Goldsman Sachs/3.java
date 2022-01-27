
import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        long p = 1;
        int res = 0;
        for (int start = 0, end = 0; end < n; end++)
        {

            p *= a[end];

            while (start < end && p >= k)
            {
                p /= a[start++];
            }

            if (p < k) {
                int len = end - start + 1;
                res += len;
            }
        }

        return res;
    }
}
