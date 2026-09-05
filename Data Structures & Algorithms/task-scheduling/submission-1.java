class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }

        int maxFreq = 0;
        int numMax = 0;

        for(int f : freq){
            if(f > maxFreq){
                maxFreq = f;
                numMax = 1;
            }
            else if(f == maxFreq){
                numMax++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + numMax;
        return Math.max(result, tasks.length);
    }
}
