class Solution {
    public int singleNumber(int[] nums) {
        // we will use bit manipulation here like xor
        
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
    }
}