class Solution {
    public boolean canJump(int[] nums) {
        int jumpIndex = nums.length - 1;
        int counter = nums.length - 1;

        while(jumpIndex != 0 && counter > 0){
            counter--;
            if(nums[counter] >= (jumpIndex - counter)){
                jumpIndex = counter;
            }
        }

        if(jumpIndex == 0){
            return true;
        }

        return false;
    }
}
