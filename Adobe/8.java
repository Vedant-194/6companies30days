//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
} 
class Solution
{
   int atoi(String str) {
       int n=str.length();
       int ans=0;
       if(str.charAt(0)=='-')
       {
           for(int i=1;i<n;i++)
           {
               if(str.charAt(i)>='0' && str.charAt(i)<='9')
               {
                   ans=(ans*10)+(str.charAt(i)-'0');
               }
               else{
                   return -1;
               }
           }
       }
       else{
           for(int i=0;i<n;i++)
           {
               if(str.charAt(i)>='0' && str.charAt(i)<='9')
               {
                   ans=(ans*10)+(str.charAt(i)-'0');
               }
               else{
                   return -1;
               }
           }
       }
       if(str.charAt(0)=='-')
       {
           return -ans;
       }
       return ans;
       
   }
}
