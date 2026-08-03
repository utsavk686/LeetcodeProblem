class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int sum=0;
        //expand the window
        for(int end =0; end<nums.length;end++){
           sum+=nums[end];

            //update the window
            while(sum>=target && start<=end){
                int currLength = end-start+1;
                minLength = Math.min(currLength, minLength);
                // window become valid - now shrink the window
                sum-=nums[start];
                start++;
            }
            

        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }else{
            return minLength;
        }
    }
}