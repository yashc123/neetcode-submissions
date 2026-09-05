class Solution {
    public int findMin(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end-start) / 2;
        int output = 0;

        while(start <= end){
            mid = start + (end-start) / 2;

            if(nums[mid] < nums[0]){
                output = nums[mid];
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return output;
    }


   
}
