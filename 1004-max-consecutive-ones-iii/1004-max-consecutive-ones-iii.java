class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0;
        int maxLength = -1;
        int  zeroCount = 0;
        //step 1: expand the window
        for(int end=0; end<nums.length;end++){
            //step 2: update the window data 
           if(nums[end]==0){
                zeroCount++;
           }
           //correct the invalid window
           //windowsize-zeroCount
           while(zeroCount>k){
            if(nums[start]==0){
                zeroCount--;
            }
            start++;
           }

           //step 4: Update the answer
           maxLength = Math.max(maxLength, end-start+1);

        }  
        return maxLength;    
    }
}