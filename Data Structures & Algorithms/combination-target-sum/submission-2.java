class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, int remaining, List<Integer> current, List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(remaining < 0){
            return;
        }

        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(nums, i, remaining - nums[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
