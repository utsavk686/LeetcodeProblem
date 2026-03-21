class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;

        //add all the value of left(K Value)
        for(int i= 0; i<k;i++){
            lSum+=cardPoints[i];
        }
        //assign the max sum as sum of all left value
        maxSum = lSum;

        int rIdx = n-1;

        //decrese the sum from left and add right value
        for(int i=k-1;i>=0;i--){
            lSum -=cardPoints[i];
            rSum +=cardPoints[rIdx]; //start adding the right Value after removing the value from left value 
            rIdx--;
            maxSum = Math.max(maxSum, lSum+rSum);

        }
        return maxSum;


    }
}