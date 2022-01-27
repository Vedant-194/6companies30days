import java.io.*;
import java.util.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.leaders(arr, n);
		    for(int i=0; i<res.size(); i++){
		        str.append(res.get(i)+" ");
		    }
		    System.out.println(str);
		}
		
	}
}
class Solution{
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        int x = arr[n-1];
        list.add(x);
        for(int i  = n-2 ; i >= 0 ; i--)
        {
            if(arr[i] >= x)
            {
                x = arr[i];
                list.add(x);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
