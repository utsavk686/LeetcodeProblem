class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        // expand the window
        for(int right = 0; right<fruits.length;right++){
            int end = fruits[right];
            if(map.containsKey(end)){
                map.put(end, map.get(end)+1);
            }
            else{
                map.put(end, 1);
            }
            // update the window data
            if(map.size()==2 || map.size()<2){
                int currLength = right-left+1;
                maxLength = Math.max(maxLength, currLength);
            }
            // if window become invalid
            while(map.size()>2){
                int start = fruits[left];
                map.put(start, map.get(start)-1);

                if(map.get(start)==0){
                    map.remove(start);
                }
                left++;
            }
        }
        return maxLength;
    }
}