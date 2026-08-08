class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        //expand the window
        for(int end = 0; end<nums.length; end++){
            //update the window
            sum+=nums[end];

            //when window become valid, upadate the answer and then shrink
            while(sum>=target && end<nums.length){
                int currLength = end-start+1;
                //update the answer
                minLength = Math.min(minLength, currLength);

                //shrink from left
                sum-=nums[start];
                start++;
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}