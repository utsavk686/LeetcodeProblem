class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        double avg = 0;
        int sum = 0;
        // check for the current window
        for(int i=0; i<k; i++){
            sum+=nums[i];
            avg = (double)sum/k;
        }
        double maxAvg = avg;
        // check for the next window
        while(right<nums.length-1){
            sum-=nums[left];
            left++;
            right++;
            sum+=nums[right];
            avg = (double)sum/k;

            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}