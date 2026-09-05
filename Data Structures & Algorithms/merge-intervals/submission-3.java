class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        if(intervals.length == 1){
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int[] comparison = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(comparison[1] < intervals[i][0]){
                result.add(comparison);
                comparison = intervals[i];
            }
            else{
                comparison[0] = Math.min(comparison[0], intervals[i][0]);
                comparison[1] = Math.max(comparison[1], intervals[i][1]);
            }
        }

        result.add(comparison);
        return result.toArray(new int[result.size()][]);
    }
}
