class Solution {
    public int lengthOfLongestSubstring(String s) {
        //start with sliding window
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
            // step 1: expand the window, add the current element in the hashMap
        for(int end = 0; end< s.length(); end++){
            char right = s.charAt(end);
            //step 2: update the window data like updatating frequency map.
            if(map.containsKey(right)){
                map.put(right, map.get(right)+1);
            }else{
                map.put(right, 1);
            }

            //step 3: correct the window
            while(map.size()<end-start+1){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);

                if(map.get(startChar)==0){
                    map.remove(startChar);
                }

                start++;
            }
            //step 4: update the result
            if(map.size()==end-start+1){
                maxLength = Math.max(maxLength, end-start+1);
            }
        }
        if(maxLength == Integer.MIN_VALUE){
            return 0; 
        }else{
            return maxLength;
        }
    }
}
