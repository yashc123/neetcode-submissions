class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

       for(int r = 0; r < n; r++){
        for(int c = r + 1; c < n; c++){
            int temp = matrix[r][c];
            matrix[r][c] = matrix[c][r];
            matrix[c][r] = temp;
        }
       }

       for(int r = 0; r < n; r++){
            int left = 0;
            int right = n - 1;

            while(left < right){
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;
                left++;
                right--;
            }
       }


    }

    /*

    1  2  3  4       13 9  5  1
    5  6  7  8       14 10 6  2
    9  10 11 12      15 11 7  3
    13 14 15 16      16 12 8  4



    */
}
