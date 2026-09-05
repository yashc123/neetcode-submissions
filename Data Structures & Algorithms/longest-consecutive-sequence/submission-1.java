class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int counter = 1;
        int maxCounter = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1] + 1){
                counter++;
            }
            else{
                if(nums[i] != nums[i-1]){
                    if(counter > maxCounter){
                        maxCounter = counter;
                    }
                    counter = 1;
                }
            }
        }
        if(counter > maxCounter){
            maxCounter = counter;
        }

        return maxCounter;
    }
}
