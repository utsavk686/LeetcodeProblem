class Solution {
    public int addDigits(int num) {
        
        while(num>=10){   // ensure last digit is single digit i.e less than 10
            int sum = 0; // it reset for each no eg. for 38->3+8=11, inner while give 11 so sum=0 and this will again do the sum of 11->1+1=2;

            // sum of digit if num is greater than 0
            while(num>0){
                sum+=num%10;   // add last digit to the sum
                num = num/10; // remove the last digit adding to sum
            }
            num = sum; // update the num value to the sum so that again 2 digit no got added

        }
        return num;
    }
}