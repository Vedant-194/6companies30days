import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}
class Solution{
    static String decodedString(String s){
       Stack<Character> stack = new Stack<>();  
        for(char c : s.toCharArray())
        {
            if(c != ']')
                stack.push(c);
            else
            {
                StringBuffer sc = new StringBuffer();
                while(stack.peek() != '[')
                {
                    sc.append(stack.pop());
                }
                stack.pop();
                int value = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                {
                    value = (stack.pop() - '0') * base + value;
                    base = base * 10;
                }
                while(value-- > 0)
                {
                    for(int i = sc.length() - 1 ; i >= 0 ; i--)
                    {
                        stack.push(sc.charAt(i));
                    }
                }
            }
        }
        StringBuffer st = new StringBuffer();
        for(int i = stack.size()-1 ; i >= 0 ; i--)
        {
            st.append(stack.pop());
        }
        return st.reverse().toString();
    }
}
