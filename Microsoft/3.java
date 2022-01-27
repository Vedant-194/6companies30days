
import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}
class GFG
{
    static void rotate(int matrix[][]) 

   {

       // Code Here

       int N = matrix.length - 1;

       int x;

       if (matrix.length % 2 != 0) {

           x = (matrix.length / 2) + 1;

       } else {

           x = matrix.length / 2;

       }

       for (int i = 0; i < x; i++) {

           for (int j = 0; j < matrix.length / 2; j++) {

               callRotation(N - j, i, N, matrix, matrix[i][j], i, j);

           }

       }

   }

   private static void callRotation(int i, int j, int N, int[][] matrix, int val, int idx, int idy) {

       if (i == idx && j == idy) {

           matrix[i][j] = val;

           return;

       }

       int temp = matrix[i][j];

       matrix[i][j] = val;

       callRotation(N - j, i, N, matrix, temp, idx, idy);

   }
}
