class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

       int twoHousesAgo = 0;
       int oneHouseAgo = 0;

       for(int i = 0; i <= nums.length - 2; i++){
            int temp = Math.max(twoHousesAgo + nums[i], oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = temp;
       }

       int passOne = oneHouseAgo;

       twoHousesAgo = 0;
       oneHouseAgo = 0;

       for(int i = 1; i < nums.length; i++){
            int temp = Math.max(twoHousesAgo + nums[i], oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = temp;
       }

       int passTwo = oneHouseAgo;

       return Math.max(passOne, passTwo);

       
    }
}
