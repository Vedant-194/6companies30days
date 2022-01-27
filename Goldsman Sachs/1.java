import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
                String[] temp = new String[string_list.length];
        for(int i = 0 ; i < string_list.length ; i++)
        {
            char [] a = (string_list[i].toCharArray());
            Arrays.sort(a);
            String b = String.valueOf(a);
            temp[i] = b;
        }
        Map<String ,List> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0 ; i < string_list.length ; i++)
        {
            if(map.containsKey(temp[i]))
                continue;
            
            List<String> l = new ArrayList<>();
            for(int j = 0 ; j < string_list.length ; j++)
            {
                if(!map.containsKey(temp[i]))
                {
                    l.add(string_list[i]);
                    map.put(temp[i],l);

                }
                else if(temp[i].compareTo(temp[j]) == 0 && i != j)
                {
                    l.add(string_list[j]);
                    map.put(temp[i],l);
                }



            }


        }
        for(String m : map.keySet())
        {
            result.add(map.get(m));

        }
        return result;

    }
}
