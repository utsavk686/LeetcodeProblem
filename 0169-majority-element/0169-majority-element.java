class Solution {
    public int majorityElement(int[] nums) {
        
//BRUTE FORCE APPROACH

        // for(int i = 0;i<nums.length;i++){
        //     int count = 0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        //     if(count>nums.length/2){
        //         return nums[i];
        //     }
        // }
        // return -1;


//OPTIMAL APPROACH -> calculate the frequency of each element and check if the element is equal to n/2

        // sort the array
        Arrays.sort(nums);

        int freq = 1; // count the first element
        int ans = nums[0]; // assume the first answer is 0th element and will update it after finding the answer

        //count the frequency of each element 
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                freq++;
            }
            else{
                freq=1;//if the element is not equal then reset the count to 1
                ans = nums[i]; // update the answer to the next element because the first answer that we assumed is not the majority element

            }
            if(freq>nums.length/2){
                return ans;
            }
        }
        return ans;
    }

}