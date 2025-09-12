class Solution {
    public boolean isPalindrome(String s) {
        // Two Pointer Approach

        int left = 0;
        int right = s.length()-1;

        while(left<right){// left!=right because we are not comparing the middle element in palindrome e.g, Ata 

        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }

        // comparing the digit are equal from both left and right side
        if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
            left++;
            right--;
        }
        return true;
    }
}