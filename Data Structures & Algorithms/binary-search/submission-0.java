class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length / 2;

        while(start <= end){
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                end = mid - 1;
                mid = (end - start) / 2 + start;
            }
            else{
                start = mid + 1;
                mid = (end - start) / 2 + start;
            }
        }

        return -1;
    }
}
