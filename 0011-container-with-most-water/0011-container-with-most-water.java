class Solution {
    public int maxArea(int[] height) {
        // two pointer
        int left = 0;
        int right = height.length-1;
        int maxWaterContained = 0;

        while(left<right){
            int containerHeight = Math.min(height[left], height[right]);
            int containerWidth = right-left;
            int currWaterContained = containerHeight*containerWidth;

            maxWaterContained = Math.max(currWaterContained, maxWaterContained);

            //check for the next container
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWaterContained;

    }
}