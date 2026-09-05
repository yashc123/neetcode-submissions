class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finalList = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                finalList.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                finalList.add(matrix[i][right]);
            }
            right--;

            for(int i = right; i >= left && top <= bottom; i--){
                finalList.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i = bottom; i >= top && left <= right; i--){
                finalList.add(matrix[i][left]);
            }
            left++;


        }

        return finalList;
    }
}
