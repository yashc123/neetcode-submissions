class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] finalResult = new int[2];

        for(int i = 0; i < nums.length; i++){

            if(map.containsKey(target - nums[i])){
                finalResult[0] = map.get(target - nums[i]);
                finalResult[1] = i;
                return finalResult;
            }

            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        return finalResult;
    }
}
