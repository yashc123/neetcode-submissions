class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> daMap = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;

            if(daMap.containsKey(diff)){
                ans[0] = daMap.get(diff);
                ans[1] = i;
                return ans;
            }

            daMap.put(num,i);
        }
        return ans;
    }
}
