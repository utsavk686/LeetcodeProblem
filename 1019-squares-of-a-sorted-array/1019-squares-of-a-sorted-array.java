class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right=n-1;
        int pos = n-1; // insert at the end first 
        int[] result = new int[n];

        while(left<=right){
            int leftVal = nums[left]*nums[left];
            int rightVal = nums[right]*nums[right];

            if(leftVal>rightVal){
                result[pos] = leftVal;
                left++;
            }else{
                result[pos] = rightVal;
                right--;
            }
            pos--;
        }
        return result;
    }
}