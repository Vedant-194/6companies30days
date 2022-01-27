import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int m = 0;
        int n = 0;
        int count = 0;
        for(int i = 0 ; i < r*c ; i ++)
        {
            arr.add(matrix[m][n]);
            if((m == count) && (n < (c - count - 1)))
            {
                n++;
                continue;
            }
            else if((n == c - 1 - count) && (m < (r - count - 1)))
            {
                m++;
                continue;
            }
            else if((m == r - 1 - count) && (n > count))
            {
                n--;
                continue;
            }
            else if((n == count) && (m > count))
            {
                m--;
                if((m == count) && (n == count))
                {
                    count++;
                    m = count;
                    n = count;
                }
                continue;
            }
        }
        return arr; 
    }
}
