class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for(int i=0; i < nums.length; i++){
            if(list.contains(nums[i])){
                return true;
            }
            else{
                list.add(nums[i]);
            }
        }
        return false;
    }
}