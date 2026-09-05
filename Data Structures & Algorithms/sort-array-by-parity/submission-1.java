class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int[] newArray = new int[nums.length];
       int nap = 0;

       for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                newArray[nap] = nums[i];
                nap++;
            }
       }

       for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                newArray[nap] = nums[i];
                nap++;
            }
       }

       return newArray;
    }
}