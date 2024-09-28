class Solution {
    public int[] plusOne(int[] digits) {
       for(int i=digits.length-1;i>=0;i--){ // check from last digits of array
        if(digits[i]<9){  // if last digit of array is less than 9 then add +1
            digits[i]++;
            return digits;
        }
        digits[i] = 0; // if last digit is 9 --> make the last digit as 0 and in the next loop it will add +1 for e.g [1,9] -> [1,0] next loop increment 1 ->[2,0];
       }
        // if all elemt are [9] in array then increase length of array and make first index 1

        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}