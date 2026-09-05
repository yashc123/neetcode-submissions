class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int overlap = 0;
        List<int[]> result = new ArrayList<>();

        int[] comparison = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(comparison[1] <= intervals[i][0]){
                result.add(comparison);
                comparison = intervals[i];
            }
            else{
                comparison[0] = Math.max(comparison[0], intervals[i][0]);
                comparison[1] = Math.min(comparison[1], intervals[i][1]);
            }
        }

        result.add(comparison);
        return intervals.length - result.size();
    }

    /*

    [1, 2]   [2, 3]   [3, 4]   [1, 3]






    */
}
