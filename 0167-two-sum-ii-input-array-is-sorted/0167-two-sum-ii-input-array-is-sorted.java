class Solution {
    // note - this solution is not valid for this questions as it is asking to complete in O(1) space, but here we are using a hashmap so space complexity became O(n)
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int req = target-numbers[i];

            if(map.containsKey(req)){
                return new int[]{map.get(req)+1, i+1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}