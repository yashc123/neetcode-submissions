class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        TreeMap<Integer, Integer> daMap = new TreeMap<>();

        for(int i = 0; i < nums.length; i++){
            daMap.put(nums[i], 0);
        }

        int storage = daMap.firstKey();
        int counter = 1;
        int maxCounter = 1;
        for(int s : daMap.keySet()){
            if(s == storage + 1){
                counter++;
                storage = s;
            }
            else{
                if(s != storage){
                    if(counter > maxCounter){
                        maxCounter = counter;
                    }
                    counter = 1;
                }
                storage = s;
            }

        }

        if(counter > maxCounter){
            maxCounter = counter;
        }

        return maxCounter;

    }
}
