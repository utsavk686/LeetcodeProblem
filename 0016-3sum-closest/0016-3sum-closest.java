class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result =0;

        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                
            int totalSum = nums[i]+nums[left]+nums[right];
            int d = Math.abs(target-totalSum);
            
            if(d<diff){
                diff = d;;
                result = totalSum;
            }
            if(totalSum<target){
                left++;
            }
            else if(totalSum>target){
                right--;
            }
            else{
                return totalSum;
            }
        }
        }
            
        return result;
    }
}