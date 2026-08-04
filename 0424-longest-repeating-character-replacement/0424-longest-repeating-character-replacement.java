class Solution {
    public int characterReplacement(String s, int k) {

        int start = 0;
        int maxLength = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Expand
        for (int end = 0; end < s.length(); end++) {

            char right = s.charAt(end);

            // Step 2: Update window data
            map.put(right, map.getOrDefault(right, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(right));

            // Step 3: Shrink while invalid
            while ((end - start + 1) - maxFreq > k) {

                char left = s.charAt(start);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                start++;
            }

            // Step 4: Update answer
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}