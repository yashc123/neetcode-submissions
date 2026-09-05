class Solution {
    public int arraySign(int[] nums) {
        int totalPos = 0;
        int totalNeg = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                return 0;
            }
            if(nums[i] > 0){
                totalPos++;
            }
            else{
                totalNeg++;
            }
        }

        if(totalNeg % 2 == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}