class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //expand the window
        for(int end =0; end<s.length();end++){
            char rightChar = s.charAt(end);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)+1);
            }else{
                map.put(rightChar, 1);
            }
            //if the window is valid, update the answer
            if(map.size()==end-start+1){
                maxLength = Math.max(maxLength, end-start+1);
            }
            //if window is invalid, correct the window(Shrink from left)
            while(map.size()<end-start+1){
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar)-1);

                //if after removing from left, the value bcome 0, remove that character from HashMap
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                start++;
            }
        }
        return maxLength;
    }
}