class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < cols; i++){
            pacific[0][i] = true;
            dfs(heights, pacific, 0, i, rows, cols);
        }

        for(int i = 0; i < rows; i++){
            pacific[i][0] = true;
            dfs(heights, pacific, i, 0, rows, cols);
        }

        for(int i = 0; i < cols; i++){
            atlantic[rows - 1][i] = true;
            dfs(heights, atlantic, rows - 1, i, rows, cols);
        }

        for(int i = 0; i < rows; i++){
            atlantic[i][cols - 1] = true;
            dfs(heights, atlantic, i, cols - 1, rows, cols);
        }

        List<List<Integer>> finalList = new ArrayList<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(r);
                    newList.add(c);
                    finalList.add(newList);
                }
            }
        }

        return finalList;


    }

    public void dfs(int[][] heights, boolean[][] ocean, int r, int c, int rows, int cols){
        ocean[r][c] = true;

        if(r + 1 < rows && heights[r+1][c] >= heights[r][c] && !ocean[r+1][c]){
            dfs(heights, ocean, r + 1, c, rows, cols);
        }
        if(r - 1 >= 0 && heights[r-1][c] >= heights[r][c] && !ocean[r-1][c]){
            dfs(heights, ocean, r - 1, c, rows, cols);
        }
        if(c + 1 < cols && heights[r][c+1] >= heights[r][c] && !ocean[r][c+1]){
            dfs(heights, ocean, r, c + 1, rows, cols);
        }
        if(c - 1 >= 0 && heights[r][c-1] >= heights[r][c] && !ocean[r][c-1]){
            dfs(heights, ocean, r, c - 1, rows, cols);
        }
    }

}
