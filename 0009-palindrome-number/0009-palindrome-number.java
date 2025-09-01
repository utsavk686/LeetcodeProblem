class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int original = x;
        while(x>0){
            int lastDigit = x%10;
            rev = (rev*10)+lastDigit;
            x = x/10;
        }

        if(rev==original){
            return true;
        }
        return false;

        
    }
}