class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxOutput = 0;
        boolean bol = true;

        while(i < j){
            int output = Math.min(heights[i], heights[j]) * (j-i);
            maxOutput = Math.max(maxOutput, output);

            if(heights[i] > heights[j]){
                j--;
            }
            else{
                i++;
            }



        }

        return maxOutput;
    }
}
