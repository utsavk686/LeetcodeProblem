class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int maxLength = 0;
        int zeroCount = 0;

        //expand the window
        for(int end = 0; end<nums.length; end++){
            //update the window
            if(nums[end]==0){
                zeroCount++;
            }

            //correct the invalid window
            while(zeroCount>=1){
                if(nums[start]==0){
                    zeroCount--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}