class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //using sliding window approach

        int start = 0;
        int zeroCount = 0;
        int maxLength = -1;

        //Exapnd the window
        for(int end = 0;end<nums.length;end++){
            //update the window data
            if(nums[end]==0){
                zeroCount++;
            }
            /*correct the invalid window, 
            since we cannot flip a single zero, valid window is zeroCount should be 0, so invalid window is zeroCount>=1*/
            while(zeroCount>=1){
                // shrink from left
                if(nums[start]==0){
                    zeroCount--;
                }
                start++;
            }
            //now update the answer when zeroCount==0
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}