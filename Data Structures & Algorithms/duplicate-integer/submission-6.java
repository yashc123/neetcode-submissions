class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> daSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(daSet.contains(nums[i])){
                return true;
            }
            else{
                daSet.add(nums[i]);
            }
        }

        return false;
    }
}