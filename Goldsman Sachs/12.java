import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.squaresInChessBoard(N));
        }
    }
}
class Solution {
    static Long squaresInChessBoard(Long N) {
        if(N == 1){
            return N;
        }
        Long ans = N*N;
        N--;
        while(N>1){
            ans += N*N;
            N--;    }
        return ++ans;}
};
