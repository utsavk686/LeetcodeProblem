class Solution {
    public int search(int[] nums, int k) {

        int start = 0;
        int end = nums.length-1;
        

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==k){
                return mid;
            }
            else if(nums[mid]<k){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
            
        }

        return -1;
        
    }
}