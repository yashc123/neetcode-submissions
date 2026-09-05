class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] finalNums = new int[k];
        Map<Integer,Integer> daMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            daMap.put(nums[i],daMap.getOrDefault(nums[i], 0) + 1);
        }

        for(int i=0; i<k; i++){
            int maxValue = Collections.max(daMap.values());

            for(int keys : daMap.keySet()){
                if(daMap.get(keys) == maxValue){
                    finalNums[i] = keys;
                    daMap.remove(keys);
                    break;
                }
            }
        }
        return finalNums;
    }
}
