class Solution {
    public int maxProduct(int[] nums) {
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length;i++){
            int version1 = nums[i];
            int version2 = minEnding*nums[i];
            int version3 = maxEnding*nums[i];

            minEnding = Math.min(version1, Math.min(version2, version3));
            maxEnding = Math.max(version1, Math.max(version2, version3));
            ans = Math.max(ans, Math.max(minEnding, maxEnding));
        }
        return ans;
    }
}