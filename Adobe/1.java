import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}
class Solution
{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int index = 0;
      int a = index;
      int sum = 0;
      ArrayList<Integer> res = new ArrayList<>();
      while(a<arr.length){
          sum +=arr[a];
          if(sum < s){
              a++;
              continue;
          }
          if(sum > s){
             index++;
             a = index;
             sum = 0;
          }
          if(sum == s){
              res.add(index+1);
              res.add(a+1);
              break;
          }
      }
      
      if(res.isEmpty()){
          res.add(-1);
          return res;
      }else{
          return res;
      }
    }
}
