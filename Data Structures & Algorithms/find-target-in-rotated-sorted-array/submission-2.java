class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            }
            else{
                return -1;
            }
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end-start) / 2;

        while(start <= end){
            mid = start + (end-start) / 2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[0] > nums[nums.length - 1]){
                if(target >= nums[0]){
                    if(nums[mid] > target){
                        end = mid - 1;
                    }
                    else if(nums[mid] < target && nums[mid] >= nums[0]){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                else{
                    if(nums[mid] < target){
                        start = mid + 1;
                    }
                    else if(nums[mid] > target && nums[mid] >= nums[0]){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
            }
            else{
                if(nums[mid] > target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
             
        }

        return -1;

        
    }
}
