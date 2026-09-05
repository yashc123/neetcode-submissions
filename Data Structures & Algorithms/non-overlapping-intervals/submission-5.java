class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int removals = 0;
        int[] comparison = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(comparison[1] <= intervals[i][0]){
                comparison = intervals[i];
            }
            else{
                removals++;
            }
        }

        return removals;
    }


}
