class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //step 1: Expand the window
        for(int end = 0; end<s.length(); end++){
            char endChar = s.charAt(end);

            //step2: update the current window
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar)+1);
            }else{
                map.put(endChar, 1);
            }

            maxFreq = Math.max(maxFreq, map.get(endChar));

            /*step3: correct the window, in this case, 
             replacementrequired = (windowSize-maxFreq)>k -> invalid
             Shrink the window from left*/
            while((end-start+1)-maxFreq>k){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);

                //if frequency becomes zero, remove from map
                if(map.get(startChar)==0){
                    map.remove(startChar);
                }

                start++;
            }
            //step 4: update the answer: now (windowSize-maxFreq)<=k
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }    
}