class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int twoHousesAgo = 0;
        int oneHouseAgo = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(nums[i] + twoHousesAgo, oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = temp;
        }

        return oneHouseAgo;
    }


    
}
