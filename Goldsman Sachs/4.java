import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
	    int count = 0;
        int ahead = 0 ;
        int back = 0;
        String result = "";

      while(ahead < str.length() && ahead >= back)
        {

            if(ahead < str.length() && str.charAt(back) == str.charAt(ahead))
            {
                count++;
                ahead++;
            }
            else
            {
                result += str.charAt(back) + String.valueOf(count);
                back = ahead;
                count = 0;
            }
            if(ahead == str.length() && str.charAt(ahead -1) == str.charAt(back))
            {
                result+= str.charAt(back) + String.valueOf(count);
            }
        }
        return result;
	}
	
 }
