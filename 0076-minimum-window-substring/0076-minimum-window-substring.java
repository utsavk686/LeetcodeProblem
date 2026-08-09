class Solution {
    public String minWindow(String s, String t) {

        // required = what we NEED from t
        HashMap<Character, Integer> required = new HashMap<>();

        // window = what we CURRENTLY HAVE
        HashMap<Character, Integer> window = new HashMap<>();


        // Store frequency of every character in t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (required.containsKey(ch)) {
                required.put(ch, required.get(ch) + 1);
            } else {
                required.put(ch, 1);
            }
        }


        int left = 0;

        // How many different character requirements are satisfied
        int formed = 0;

        // Number of different characters we need to satisfy
        int requiredCount = required.size();

        // Smallest window length found so far
        int minLength = Integer.MAX_VALUE;

        // Starting position of the smallest window
        int start = 0;


        // =========================================================
        // STEP 1: EXPAND THE WINDOW
        // =========================================================
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);


            // =====================================================
            // STEP 2: UPDATE WINDOW DATA
            // =====================================================

            if (window.containsKey(rightChar)) {
                window.put(rightChar, window.get(rightChar) + 1);
            } else {
                window.put(rightChar, 1);
            }


            // Check whether this character has now satisfied
            // its required frequency.
            //
            // Example:
            // required: A -> 2
            // window:   A -> 2
            //
            // A requirement is now satisfied.
            if (required.containsKey(rightChar)
                    && window.get(rightChar).equals(required.get(rightChar))) {

                formed++;
            }


            // =====================================================
            // STEP 3: WHILE WINDOW IS VALID
            // =====================================================
            while (formed == requiredCount) {


                // -----------------------------------------------
                // Update the minimum answer
                // -----------------------------------------------

                int currentLength = right - left + 1;

                if (currentLength < minLength) {

                    minLength = currentLength;

                    // Remember where this best window starts
                    start = left;
                }


                // -----------------------------------------------
                // Shrink the window from the left
                // -----------------------------------------------

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);


                // If removing this character makes the window
                // invalid, decrease formed.
                if (required.containsKey(leftChar)
                        && window.get(leftChar) < required.get(leftChar)) {

                    formed--;
                }

                left++;
            }


            // =====================================================
            // STEP 4: CONTINUE EXPANDING
            // =====================================================
            // When the window becomes invalid, the while loop stops.
            // The for-loop then increases right and expands again.
        }


        // No valid window found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }


        // Return the smallest valid substring
        return s.substring(start, start + minLength);
    }
}