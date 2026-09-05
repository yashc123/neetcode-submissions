class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int product = 1;
        int zeroNum = 0;
        int oneZeroProduct = 1;
        for(int i=0; i < nums.length; i++){
            product *= nums[i];

            if(nums[i] != 0){
                oneZeroProduct *= nums[i];
            }
            else{
                zeroNum++;
            }

            if(zeroNum > 1){
                return result;
            }
        }

        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){
                result[i] = product / nums[i];
            }
            else{
                result[i] = oneZeroProduct;
            }
        }

        return result;
    }
}  
