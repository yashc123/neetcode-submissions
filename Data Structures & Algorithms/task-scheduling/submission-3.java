class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tracker = new int[26];
        int mostFrequent = 0;
        int numMax = 1;

        for(char c : tasks){
            tracker[c - 'A']++;
            if(tracker[c - 'A'] > mostFrequent){
                mostFrequent = tracker[c - 'A'];
                numMax = 1;
            }
            else if(tracker[c - 'A'] == mostFrequent){
                numMax++;
            }
        }



        int minSpots = (n + 1) * (mostFrequent - 1) + numMax;
        return Math.max(tasks.length, minSpots);
    }
}
