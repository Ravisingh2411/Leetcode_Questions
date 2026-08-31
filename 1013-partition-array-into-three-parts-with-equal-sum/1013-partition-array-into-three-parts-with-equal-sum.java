class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        if(sum % 3 != 0){
            return false;
        }

        int each = sum / 3;
        int currSum = 0;
        int count = 0;
        for(int ele : arr){
            currSum += ele;
            if(currSum == each){
                count++;
                currSum = 0;
            }
        }
        return count >= 3;
    }
}