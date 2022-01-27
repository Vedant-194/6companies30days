//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
class Solution
{
    static int res = 0;
    static int checkRecursive(int num, int x, int k, int n)
    {
        if (x == 0)
            res++;
         
        int r = (int)Math.floor(Math.pow(num, 1.0 / n));
 
        for (int i = k + 1; i <= r; i++) {
            int a = x - (int)Math.pow(i, n);
          if (a >= 0)
            checkRecursive(num,
                   x - (int)Math.pow(i, n), i, n);
        }
        return res;
    }
     
    static int numOfWays(int n, int x)
    {
        return checkRecursive(x, x, 0, n);
    }
}
