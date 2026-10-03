class Solution {
    public int maxSubArray(int[] nums) {
        //using the Kadanes algorithm
        int bestEnding = nums[0];
        int ans = nums[0];
        

        for(int i=1;i<nums.length;i++){
            int version1 = bestEnding+nums[i];
            int version2 = nums[i];

            bestEnding = Math.max(version1, version2);
            ans = Math.max(ans, bestEnding);
        }
        return ans;
    }
}