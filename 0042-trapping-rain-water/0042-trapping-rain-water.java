class Solution {
    public int trap(int[] height) {
        // 1. finding the left max

        int[] leftmax = new int[height.length];
        leftmax[0] = height[0];
        for(int i=1; i<=height.length-1;i++){
            leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }

        //2. Finding the rightmax
        
        int[] rightmax = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];

        for(int i= height.length-2; i>=0; i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        //3. finding the water level i.e. min of max length
        int trappedWater = 0;
        for(int i=0;i<height.length;i++){
            int waterLevel = Math.min(leftmax[i], rightmax[i]);
            trappedWater+=waterLevel-height[i];
        }
        return trappedWater;
    }
}