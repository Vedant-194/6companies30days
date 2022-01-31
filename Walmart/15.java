class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend>=0)==(divisor>=0)?true:false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        int temp = 0;
        int prev = 0;
        while(dividend-divisor>=0){
            int count = 0;
            temp = divisor;
            prev =0;
            while(dividend-temp>=0){
                prev = temp;
                temp = temp<<1;
                count++;
            }
            result+=1<<count-1;
            dividend -=prev;
        }
        return sign?result:-result;
    }
}
