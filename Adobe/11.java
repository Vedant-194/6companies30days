//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
       String str = "";
        str +=  Character.toString(s.charAt(0)).toLowerCase();
        int i = 1;
        while(i<s.length()){
            if(Character.isUpperCase(s.charAt(i))){
                str += " ";
                str += Character.toString(s.charAt(i++)).toLowerCase();
            }
            else
                str += s.charAt(i++);
        }
        return str;
}
}
