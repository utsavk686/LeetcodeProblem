class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int ans = 0;
       

        while(start<=end){
            int mid = start + (end - start) / 2; // using this to find mid to stop overflow for large integer num
             long sq = (long) mid*mid; // convering into long because it will be to long if we multiply twol large integer
           if(sq ==x){
            return mid;
           }
           else if(sq>x){
            
            end = mid-1;
            
           }
           else{
            ans = mid;
            start=mid+1;
           }
        }
        return ans;
    }
}