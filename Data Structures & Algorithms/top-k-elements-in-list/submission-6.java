class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                int[] finalNums = new int[k];
        Map<Integer,Integer> daMap = new HashMap<>();

        for(int n : nums){
            daMap.put(n, daMap.getOrDefault(n,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i <= nums.length; i++){
            buckets[i] = new ArrayList<>();
        }

        for(int boss : daMap.keySet()){
            buckets[daMap.get(boss)].add(boss);
        }

        int b = 0;
        for(int j = nums.length; j > 0 && b < k; j--){
            for(int n : buckets[j]){
                finalNums[b++] = n;
                if(b == k) return finalNums;
            }
        }

        return finalNums;
    }
}
