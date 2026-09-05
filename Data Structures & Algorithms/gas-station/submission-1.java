class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currGas += diff;

            if (currGas < 0) {
                currGas = 0;
                startIndex = i + 1;
            }
        }

        if(totalGas >= 0){
            return startIndex;
        }
        else{
            return -1;
        }
        
    }
}

