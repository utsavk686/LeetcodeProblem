class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        //Step 1: find the total sum
        for(int i=0;i<n;i++){
            totalSum+=cardPoints[i];
        }
        //find the size of middle part
        int windowSize = n-k;

        //if we take all cards
        if(windowSize==0){
            return totalSum;
        }
        //first window Size
        int windowSum = 0;
        int minSum = 0;
        for(int i=0;i<windowSize;i++){
            windowSum+=cardPoints[i];
        }
        minSum = windowSum;

        //sliding window
        for(int i=windowSize;i<n;i++){
            windowSum=windowSum+cardPoints[i]-cardPoints[i-windowSize];
            minSum = Math.min(windowSum, minSum);
        }
        return totalSum-minSum;


    }
}