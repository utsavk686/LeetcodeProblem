class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int pos = nums.length-1;
        int[] result = new int[nums.length];
        
        while(left<=right){
            int leftval = nums[left]* nums[left];
            int rightval = nums[right]* nums[right];

            if(leftval>rightval){
                result[pos] = leftval;
                left++;
                pos--;
            }
            else{
                result[pos] = rightval;
                right--;
                pos--;
            }

        }
        return result;
    }
}