class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int waterLevel = 0;
        int leftMax = height[0];
        int rightMax = height[j];

        while(i < j){
            if(leftMax < rightMax){
                i++;
                leftMax = Math.max(height[i], leftMax);
                waterLevel += leftMax - height[i];
            }
            else{
                j--;
                rightMax = Math.max(height[j], rightMax);
                waterLevel += rightMax - height[j];
            }
        }
        
        return waterLevel;
    }
}





