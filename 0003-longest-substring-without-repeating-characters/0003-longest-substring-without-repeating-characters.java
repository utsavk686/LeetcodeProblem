class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //step1: expand the window
        for(int end = 0; end<s.length(); end++){
            char endChar = s.charAt(end);
            //step2: Update window data
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar)+1);
            }else{
                map.put(endChar, 1);
            }
            //step 3: correct invalid window
            while(map.size()<end-left+1){
                //shrink from left
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);

                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }

            // now the window is valid, update the answer
            maxLength = Math.max(maxLength, end-left+1);
        }
        return maxLength;
    }
}