import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        
            HashSet<String> set = new HashSet<>();
        for(String x : contact)
            set.add(x);
        contact = new String[set.size()];
        int i = 0 ;
        for(String x : set)
            contact[i++] = x;
        Arrays.sort(contact);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(i = 0 ; i < s.length() ; i++)
            list.add(new ArrayList<>());
        for(String st : contact)
        {
            for(i = 0 ; i < st.length() ; i++)
            {
                if(i < s.length() && s.charAt(i) == st.charAt(i))
                {
                    list.get(i).add(st);
                }
                else
                {
                    break;
                }
            }
        }
        for(i = 0 ; i < s.length() ; i++)
        {
            if(list.get(i).size() == 0)
                list.get(i).add("0");
        }
        return list;
    
    }
}
