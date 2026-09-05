class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    queue.add(new int[]{r, c});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if(r + 1 < rows && grid[r+1][c] == Integer.MAX_VALUE){
                grid[r+1][c] = grid[r][c] + 1;
                queue.add(new int[]{r + 1, c});
            }

            if(r - 1 >= 0 && grid[r-1][c] == Integer.MAX_VALUE){
                grid[r-1][c] = grid[r][c] + 1;
                queue.add(new int[]{r - 1, c});
            }

            if(c + 1 < cols && grid[r][c+1] == Integer.MAX_VALUE){
                grid[r][c+1] = grid[r][c] + 1;
                queue.add(new int[]{r, c + 1});
            }

            if(c - 1 >= 0 && grid[r][c-1] == Integer.MAX_VALUE){
                grid[r][c-1] = grid[r][c] + 1;
                queue.add(new int[]{r, c - 1});
            }
        }
    }


}
