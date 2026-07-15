class Solution {
    public int findDuplicate(int[] nums) {
        // brute force approach
        Arrays.sort(nums);
        
        int leftpointer=0;
        int nextpointer = leftpointer+1;

        while(leftpointer<nextpointer && nextpointer<nums.length){
            if(nums[leftpointer]!=nums[nextpointer]){
                leftpointer++;
                nextpointer++;
            }else{
                return nums[leftpointer];
            }
        }
        return -1;
    }
}