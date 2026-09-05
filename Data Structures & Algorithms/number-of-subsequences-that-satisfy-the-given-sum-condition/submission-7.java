class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int sequences = 0;
        int mod = 1000000007;

        for(int i = 0; i < nums.length; i++){
            int end = i;
            if(nums[i] + nums[i] > target){
                break;
            }
           while(end < nums.length && nums[i] + nums[end] <= target){
            end++;
           }

           long power = 1;
           for(int m = 0; m < end - i - 1; m++){
                power = (power * 2) % mod;
           }

           sequences = (int) ((sequences + power ) % mod);
        }

        return sequences;
    }
}