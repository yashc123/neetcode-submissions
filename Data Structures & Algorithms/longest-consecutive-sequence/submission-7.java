class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Set<Integer> daSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            daSet.add(nums[i]);
        }

        int maxCounter = 1;
        for(int num: nums){
            if(!daSet.contains(num - 1)){
                int counter = 1;
                while(daSet.contains(num + counter)){
                    counter++;
                }

                maxCounter = Math.max(counter, maxCounter);
            }
        }

        return maxCounter;

    }
}
